package se.app.customer.regular;

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
import se.common.CommonService;
import se.common.accounts.Account;
import se.common.accounts.CurrentUser;

@Controller
@RequestMapping(value = "/app/customer/regular", produces = MediaTypes.HAL_JSON_VALUE)
public class RegularController extends CommonController{
	@Autowired
    RegularService regularService;
	
	@Autowired
    CommonService commonService;

	private final RegularValidator regularValidator;
	
    private final RegularRegistValidator regularRegistValidator;
    
    private final RegularWithdrawValidator regularWithdrawValidator;
    
    private final BasicInfoRegistValidator basicInfoRegistValidator;

    public RegularController(RegularRegistValidator regularRegistValidator, RegularValidator regularValidator, RegularWithdrawValidator regularWithdrawValidator, BasicInfoRegistValidator basicInfoRegistValidator) {
    	this.regularValidator = regularValidator;
        this.regularRegistValidator = regularRegistValidator;
        this.regularWithdrawValidator = regularWithdrawValidator;
        this.basicInfoRegistValidator = basicInfoRegistValidator;
    }
    
    // 정회원 인증
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/certify", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<JSONObject>> customerRegularInfo(HttpServletRequest request,
    															@RequestBody @Valid RegularDto regular,
																Errors errors,
																@CurrentUser Account currentUser) throws Exception {
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(regular));
    	
    	try {
    		regularValidator.validate(regular, errors);
    		if (errors.hasErrors()) {
        		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
                return badRequest(errors);
            }
		} catch (Exception e) {
			errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
    	
    	List<RegularDto> regularInfo = null;
    	try {
    		if(regular.getSearch_type().equals("CI")){
    			regularInfo = regularService.selectRegularVehicInfo4PASSKEY(regular);
    		} else {
    			regularInfo = regularService.selectRegularVehicInfo(regular);
    		}
    	} catch (Exception e) {
    		errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
    	
        List<JSONObject> entities = new ArrayList<JSONObject>();
        for (RegularDto n : regularInfo) {
            JSONObject entity = new JSONObject();
            entity.put("cust_nm", n.getCust_nm());
            entity.put("hp_no", n.getHp_no());
            entity.put("cust_seq", n.getCust_seq());
            entity.put("vehic_no", n.getVehic_no());
            entity.put("group_id", n.getGroup_id());
            entity.put("group_name", n.getGroup_name());
            entity.put("group_tell_no", n.getGroup_tell_no());
            entity.put("vin", n.getVin());
            entity.put("brand_nm", n.getBrand_nm());
            entity.put("model_nm", n.getModel_nm());
            entity.put("variant_nm", n.getVariant_nm());
            entity.put("model_year", n.getModel_year());
            entity.put("sfx_nm", n.getSfx_nm());
            entity.put("col_combi_cd", n.getCol_combi_cd());
            entity.put("col_combi_nm", n.getCol_combi_nm());
            entity.put("contract_stat_cd", n.getContract_stat_cd());
            entity.put("contract_stat_nm", n.getContract_stat_nm());
            entity.put("dlr_contract_no", n.getDlr_contract_no());
            entity.put("dealer_id", n.getDealer_id());
            entity.put("mng_sc_id", n.getMng_sc_id());
            entity.put("mng_sc_hp", n.getMng_sc_hp()); 
            
            entities.add(entity);
        }
        
        responseLog(log_seq, new Gson().toJson(entities));
        
        return new ResponseEntity<List<JSONObject>>(entities, HttpStatus.OK);
    }
    
    // 정회원 등록
    @RequestMapping(value = "/regist", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity customerRegularRegist(HttpServletRequest request,
    											@RequestBody @Valid RegularRegistDto regular,
    											Errors errors,
    											@CurrentUser Account currentUser) throws Exception {
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(regular));
    	
    	regularRegistValidator.validate(regular, errors);
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
            return badRequest(errors);
        }
    	
    	try {
    		insertInterfaceMaster(CommonConst.KEY_REGULAR_REGIST, new Gson().toJson(regular));
    		
    		RegularDto param = new RegularDto();
    		param.setHp_no(regular.getHp_no());
    		param.setVin(regular.getVin());
    		param.setSearch_type("HV");
    		
    		List<RegularDto> regularList = regularService.selectRegularVehicInfo(param);
    		
    		if(regularList.size()>0) {
    			for(int i=0; i<regularList.size(); i++) {
    				RegularDto vehicParam = new RegularDto();
        			vehicParam = regularList.get(i);
        			regular.setVin(vehicParam.getVin());
        			regularService.insertLPMVehicUseInfo(regular);
    			}
    		}
		} catch (Exception e) {
			errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
        
    	RegularRegistResource regularRegistResource = new RegularRegistResource(regular);
    	
        responseLog(log_seq, new Gson().toJson(regularRegistResource.getContent()));
        
        return ResponseEntity.ok(regularRegistResource);
    }
    
    // 정회원 탈퇴
    @RequestMapping(value = "/withdraw", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity customerRegularWithdraw(HttpServletRequest request,
    											@RequestBody @Valid RegularWithdrawDto regular,
    											Errors errors,
    											@CurrentUser Account currentUser) throws Exception {
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(regular));
    	
    	try {
    		regularWithdrawValidator.validate(regular, errors);
    		if (errors.hasErrors()) {
        		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
                return badRequest(errors);
            }
		} catch (Exception e) {
			errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
    	
    	try {
    		insertInterfaceMaster(CommonConst.KEY_REGULAR_WITHDRAW, new Gson().toJson(regular));
		} catch (Exception e) {
			errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
    	
        
    	RegularWithdrawResource regularWithdrawResource = new RegularWithdrawResource(regular);
    	
        responseLog(log_seq, new Gson().toJson(regularWithdrawResource.getContent()));
        
        return ResponseEntity.ok(regularWithdrawResource);
    }
    
    // 기본정보 저장
    @RequestMapping(value = "/basic-info/regist", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity customerRegularBasicInfoRegist(HttpServletRequest request,
    											@RequestBody @Valid BasicInfoRegistDto basicInfo,
    											Errors errors,
    											@CurrentUser Account currentUser) throws Exception {
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(basicInfo));
    	
    	basicInfoRegistValidator.validate(basicInfo, errors);
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
            return badRequest(errors);
        }
    	
    	try {
    		insertInterfaceMaster(CommonConst.KEY_BASICINFO_REGIST, new Gson().toJson(basicInfo));
		} catch (Exception e) {
			errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
        
    	BasicInfoRegistResource regularRegistResource = new BasicInfoRegistResource(basicInfo);
    	
        responseLog(log_seq, new Gson().toJson(regularRegistResource.getContent()));
        
        return ResponseEntity.ok(regularRegistResource);
    }
}
