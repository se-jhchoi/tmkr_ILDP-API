package se.app.svc.coupon;

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
import se.common.CommonController;
import se.common.accounts.Account;
import se.common.accounts.CurrentUser;

@Controller
@RequestMapping(value = "/app/svc/coupon/", produces = MediaTypes.HAL_JSON_VALUE)
public class CouponController extends CommonController{
	@Autowired
    CouponService couponService;

    private final FmsListValidator fmsListValidator;
    
    private final PspListValidator pspListValidator;


    public CouponController(FmsListValidator fmsListValidator, PspListValidator pspListValidator) {
        this.fmsListValidator = fmsListValidator;
        this.pspListValidator = pspListValidator;
    }
    
    // FMS 쿠폰 리스트 (사용 중지)
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/fms/list", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<JSONObject>> fmsListInfo(HttpServletRequest request, @RequestBody @Valid FmsListDto coupon, Errors errors, @CurrentUser Account currentUser) throws Exception {
    	//로그
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(coupon));
    	
    	fmsListValidator.validate(coupon, errors);
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
    		return badRequest(errors);
        }
    	
    	List<FmsListDto> fmsListList = null;
    	try {
    		fmsListList = couponService.selectFmsList(coupon);
    	} catch (Exception e) {
    		errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
    	/*
    	if(fmsListList.size()==0) {
    		coupon = new FmsListDto();
    	}
    	*/
    	
        List<JSONObject> entities = new ArrayList<JSONObject>();
        for (FmsListDto n : fmsListList) {
            JSONObject entity = new JSONObject();
            entity.put("coupon_type", n.getCoupon_type());
            entity.put("coupon_type_nm", n.getCoupon_type_nm());
            entity.put("item_type", n.getItem_type());
            entity.put("pm_nm", n.getPm_nm());
            entity.put("item_type_nm", n.getItem_type_nm());
            entity.put("fms_item_nm", n.getFms_item_nm());
            entity.put("apply_st_date", n.getApply_st_date());
            entity.put("apply_end_date", n.getApply_end_date());
            entity.put("exec_shop_nm", n.getExec_shop_nm());
            entity.put("exec_yn", n.getExec_yn());
            entity.put("exec_date", n.getExec_date());
            entity.put("can_use_yn", n.getCan_use_yn());
            entities.add(entity);
        }
        
        //로그
        responseLog(log_seq, new Gson().toJson(entities));
        
        return new ResponseEntity<List<JSONObject>>(entities, HttpStatus.OK);
    }
    
    //  프로모션 & FMS 쿠폰 리스트
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/fms/PromotionFmslist", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<JSONObject>> PromotionFmsListInfo(HttpServletRequest request, @RequestBody @Valid FmsListDto coupon, Errors errors, @CurrentUser Account currentUser) throws Exception {
    	//로그
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(coupon));
    	
    	fmsListValidator.validate(coupon, errors);
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
    		return badRequest(errors);
        }
    	
    	List<FmsListDto> fmsListList = null;
    	try {
    		fmsListList = couponService.selectPromotionFmsList(coupon);
    	} catch (Exception e) {
    		errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
    	/*
    	if(fmsListList.size()==0) {
    		coupon = new FmsListDto();
    	}
    	*/
    	
        List<JSONObject> entities = new ArrayList<JSONObject>();
        for (FmsListDto n : fmsListList) {
            JSONObject entity = new JSONObject();
            entity.put("pm_group_code", n.getPm_group_code());
            entity.put("coupon_type", n.getCoupon_type());
            entity.put("coupon_type_nm", n.getCoupon_type_nm());
            entity.put("item_type", n.getItem_type());
            entity.put("pm_nm", n.getPm_nm());
            entity.put("item_type_nm", n.getItem_type_nm());
            entity.put("fms_item_nm", n.getFms_item_nm());
            entity.put("apply_st_date", n.getApply_st_date());
            entity.put("apply_end_date", n.getApply_end_date());
            entity.put("exec_shop_nm", n.getExec_shop_nm());
            entity.put("exec_yn", n.getExec_yn());
            entity.put("exec_date", n.getExec_date());
            entity.put("can_use_yn", n.getCan_use_yn());
            entities.add(entity);
        }
        
        //로그
        responseLog(log_seq, new Gson().toJson(entities));
        
        return new ResponseEntity<List<JSONObject>>(entities, HttpStatus.OK);
    }
    
    // PSP 쿠폰 리스트
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/psp/list", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<JSONObject>> pspListInfo(HttpServletRequest request, @RequestBody @Valid PspListDto coupon, Errors errors, @CurrentUser Account currentUser) throws Exception {
    	//로그
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(coupon));
    	
    	pspListValidator.validate(coupon, errors);
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
    		return badRequest(errors);
        }
    	
    	List<PspListDto> pspListList = null;
    	try {
    		pspListList = couponService.selectPspList(coupon);
    	} catch (Exception e) {
    		errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
    	/*
    	if(pspListList.size()==0) {
    		coupon = new PspListDto();
    	}
    	*/
    	
        List<JSONObject> entities = new ArrayList<JSONObject>();
        for (PspListDto n : pspListList) {
            JSONObject entity = new JSONObject();
            entity.put("psp_item_nm", n.getPsp_item_nm());
            entity.put("apply_st_date", n.getApply_st_date());
            entity.put("apply_end_date", n.getApply_end_date());
            entity.put("exec_shop_nm", n.getExec_shop_nm());
            entity.put("exec_yn", n.getExec_yn());
            entity.put("exec_date", n.getExec_date());
            entity.put("can_use_yn", n.getCan_use_yn());
            entities.add(entity);
        }
        
        //로그
        responseLog(log_seq, new Gson().toJson(entities));
        
        return new ResponseEntity<List<JSONObject>>(entities, HttpStatus.OK);
    }
}
