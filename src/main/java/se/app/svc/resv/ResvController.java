package se.app.svc.resv;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import net.minidev.json.JSONObject;
import se.common.CommonConst;
import se.common.CommonController;
import se.common.accounts.Account;
import se.common.accounts.CurrentUser;

@Controller
@RequestMapping(value = "/app/svc/resv", produces = MediaTypes.HAL_JSON_VALUE)
public class ResvController extends CommonController {
	@Autowired
    ResvService resvsService;

	private final ResvRegistValidator resvRegistValidator;
	
	private final ResvCancelValidator resvCancelValidator;
	
    private final ResvValidator resvValidator;
    
    private final CenterResvValidator centerResvValidator;
    
    private final UsableTimeValidator usableTimeValidator;
    
    private final RemindReactionValidator reminReactionValidator;
    
    private	final ResvStatusSearchValidator resvStatusSearchValidator;

    public ResvController(ResvValidator resvValidator, CenterResvValidator centerResvValidator, ResvRegistValidator resvRegistValidator, ResvCancelValidator resvCancelValidator, UsableTimeValidator usableTimeValidator, RemindReactionValidator reminReactionValidator, ResvStatusSearchValidator resvStatusSearchValidator) {
        this.resvValidator = resvValidator;
        this.centerResvValidator = centerResvValidator;
        this.resvRegistValidator = resvRegistValidator;
        this.resvCancelValidator = resvCancelValidator;
        this.usableTimeValidator = usableTimeValidator;
        this.reminReactionValidator = reminReactionValidator;
		this.resvStatusSearchValidator = resvStatusSearchValidator;
    }
    
    // 서비스 예약 등록
    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "/regist", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity resvRegist(HttpServletRequest request, 
    									@RequestBody @Valid ResvRegistDto resv,
    									Errors errors,
    									@CurrentUser Account currentUser) throws Exception {
    	//로그
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(resv));
    	
    	resvRegistValidator.validate(resv, errors);
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
            return badRequest(errors);
        }
    	
    	try {
    		if(resvsService.selectResvChkDuplication(resv)>0) {
    			errors.reject("005", "Invalid Result : 중복된 예약이 있습니다.");
    			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
                return badRequest(errors);
    		}
    		
    		if(resvsService.selectResvChkResvTime(resv)>0) {
    			errors.reject("005", "Invalid Result : 해당 시간은 이미 예약되어 있습니다.");
    			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
                return badRequest(errors);
    		}
		} catch (Exception e) {
			errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
    	
    	
    	try {
    		resvsService.insertResv(resv);
    		insertInterfaceMaster(CommonConst.KEY_RESV_REGIST, new Gson().toJson(resv));
		} catch (Exception e) {
			errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
        
    	ResvRegistResource resvResource = new ResvRegistResource(resv);
    	
    	//로그
        responseLog(log_seq, new Gson().toJson(resvResource.getContent()));

        return ResponseEntity.ok(resvResource);
    }
    
    // 서비스 예약 취소
    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "/cancel", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity resvCancel(HttpServletRequest request, 
    									@RequestBody @Valid ResvCancelDto resv,
    									Errors errors,
    									@CurrentUser Account currentUser) throws Exception {
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(resv));
    	
    	resvCancelValidator.validate(resv, errors);
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
            return badRequest(errors);
        }
    	
    	try {
    		resvsService.updateResvCancel(resv);
    		insertInterfaceMaster(CommonConst.KEY_RESV_CANCEL, new Gson().toJson(resv));
		} catch (Exception e) {
			errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
        
    	ResvCancelResource resvResource = new ResvCancelResource(resv);
    	
        responseLog(log_seq, new Gson().toJson(resvResource.getContent()));

        return ResponseEntity.ok(resvResource);
    }
    
    // 서비스 예약 리스트 조회
    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity resvInfo(HttpServletRequest request, 
    									@RequestBody @Valid ResvDto resv,
    									Errors errors,
    									@CurrentUser Account currentUser) throws Exception {
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(resv));
    	
    	resvValidator.validate(resv, errors, "list");
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
            return badRequest(errors);
        }
    	
    	List<ResvDto> resvList = null;
    	try {
    		if(resv.getSearch_type().equals("LIST")) {
    			resvList = resvsService.selectResvList(resv);
    		} else if(resv.getSearch_type().equals("DT")) {
    			resvList = resvsService.selectResv4ResvDt(resv);
    		}
    		
		} catch (Exception e) {
			errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
    	
        
    	if(resvList.size()==0) {
    		resv = new ResvDto();
    	}
    	
    	List<JSONObject> entities = new ArrayList<JSONObject>();
        for (ResvDto n : resvList) {
            JSONObject entity = new JSONObject();
            entity.put("vin", n.getVin());
            entity.put("shop_cd", n.getShop_cd());
            entity.put("shop_nm", n.getShop_nm());
            entity.put("variant_nm", n.getVariant_nm());
            entity.put("vehic_no", n.getVehic_no());
            entity.put("full_resv_date", n.getFull_resv_date());
            entity.put("svc_type_cd", n.getSvc_type_cd());
            entity.put("svc_type_nm", n.getSvc_type_nm());
            entity.put("stat_cd", n.getStat_cd());
            entity.put("stat_nm", n.getStat_nm());
            entity.put("resv_date", n.getResv_date());
            entity.put("resv_st_hm", n.getResv_st_hm());
            entity.put("resv_end_hm", n.getResv_end_hm());
            entity.put("resv_dt", n.getResv_dt());
            entity.put("resv_seq", n.getResv_seq());
            entity.put("resv_ildp_seq", n.getResv_ildp_seq());
            
            entities.add(entity);
        }
        
        responseLog(log_seq, new Gson().toJson(entities));
        
        return new ResponseEntity<List<JSONObject>>(entities, HttpStatus.OK);
    }
    
    // 고객이 최근 방문한 서비스센터 정보
    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "/last-visit/search", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity resvLastVisitSvc(HttpServletRequest request, 
    									@RequestBody @Valid ResvDto resv,
    									Errors errors,
    									@CurrentUser Account currentUser) throws Exception {
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(resv));
    	
    	resvValidator.validate(resv, errors, "last-visit");
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
            return badRequest(errors);
        }
    	
    	try {
    		resv = resvsService.selectLastVisitSvc(resv);
		} catch (Exception e) {
			errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
        
    	if(resv==null) {
    		resv = new ResvDto();
    	}
    	
    	ResvResource resvResource = new ResvResource(resv);
    	
        responseLog(log_seq, new Gson().toJson(resvResource.getContent()));

        return ResponseEntity.ok(resvResource);
    }

    // 서비스센터에 예약가능 타임 테이블 정보
    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "/usable-time/list", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity resvAble(HttpServletRequest request, 
    									@RequestBody @Valid UsableTimeDto resv,
    									Errors errors,
    									@CurrentUser Account currentUser) throws Exception {
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(resv));
    	
    	usableTimeValidator.validate(resv, errors);
    	
    	resv.setResv_date_dateformat(resv.getResv_date().substring(0,4)+"-"+resv.getResv_date().substring(4,6)+"-"+resv.getResv_date().substring(6,8));
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
            return badRequest(errors);
        }
    	
    	List<UsableTimeResultDto> usableTimeResult = null;
    	try {
    		usableTimeResult = resvsService.selectUsableTimeList(resv);
		} catch (Exception e) {
			errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
    	
    	
    	List<JSONObject> entities = new ArrayList<JSONObject>();
        for (UsableTimeResultDto n : usableTimeResult) {
            JSONObject entity = new JSONObject();
            entity.put("hh_mm", n.getHh_mm());
            entity.put("stall_no", n.getStall_no());
            entities.add(entity);
        }
        
        responseLog(log_seq, new Gson().toJson(entities));
        
        return new ResponseEntity<List<JSONObject>>(entities, HttpStatus.OK);
    }
    
    // 예약 리마인드 리액션
    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "/remind-reaction/regist", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity resvRemindReaction(HttpServletRequest request, 
    									@RequestBody @Valid RemindReactionDto resv,
    									Errors errors,
    									@CurrentUser Account currentUser) throws Exception {
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(resv));
    	
    	reminReactionValidator.validate(resv, errors);
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
            return badRequest(errors);
        }
    	
    	try {
    		insertInterfaceMaster(CommonConst.KEY_REMIND_REACTION, new Gson().toJson(resv));
		} catch (Exception e) {
			errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
        
    	RemindReactionResource resvResource = new RemindReactionResource(resv);
    	
        responseLog(log_seq, new Gson().toJson(resvResource.getContent()));

        return ResponseEntity.ok(resvResource);
    }
    
    // 예약 상태 조회
    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "/statusSearch", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity resvStatusSearch(HttpServletRequest request, 
    									@RequestBody @Valid ResvStatusSearchDto resv,
    									Errors errors,
    									@CurrentUser Account currentUser) throws Exception {

    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(resv));
    	
    	resvStatusSearchValidator.validate(resv, errors);
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
            return badRequest(errors);
        }
    	
    	List<ResvStatusSearchDto> resvList = null;
    	
    	try {
    		resvList = resvsService.selectResvStatusSearch(resv);
		} catch (Exception e) {
			errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
    	
        
    	if(resvList.size()==0) {
    		resv = new ResvStatusSearchDto();
    	}
    	
    	List<JSONObject> entities = new ArrayList<JSONObject>();
        for (ResvStatusSearchDto n : resvList) {
            JSONObject entity = new JSONObject();
            
            entity.put("shop_cd", n.getShop_cd());
            entity.put("resv_dt", n.getResv_dt());
            entity.put("resv_seq", n.getResv_seq());
            entity.put("stat_cd", n.getStat_cd());
            entity.put("stat_nm", n.getStat_nm());
            
            entities.add(entity);
        }
        
        responseLog(log_seq, new Gson().toJson(entities));
        
        return new ResponseEntity<List<JSONObject>>(entities, HttpStatus.OK);
        
    }
}