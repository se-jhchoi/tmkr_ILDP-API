package se.app.svc;

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
import se.common.SearchDateDto;
import se.common.accounts.Account;
import se.common.accounts.CurrentUser;

@Controller
@RequestMapping(value = "/app/svc/hist", produces = MediaTypes.HAL_JSON_VALUE)
public class SvcHistController extends CommonController{
	@Autowired
    SvcHistService svcHistService;

    private final SvcHistValidator svcHistValidator;
    
    private final RepairMainValidator repairMainValidator;
    
    private final RepairDetailValidator repairDetailValidator;

    public SvcHistController(SvcHistValidator svcHistValidator, RepairMainValidator repairMainValidator, RepairDetailValidator repairDetailValidator) {
        this.svcHistValidator = svcHistValidator;
        this.repairMainValidator = repairMainValidator;
        this.repairDetailValidator = repairDetailValidator;
    }
    
    // 정비이력
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<JSONObject>> svcHistRegularInfo(HttpServletRequest request, @RequestBody @Valid SearchDateDto sd, Errors errors, @CurrentUser Account currentUser) throws Exception {
    	//로그
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(sd));
    	
    	svcHistValidator.validate(sd, errors);
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
    		return badRequest(errors);
        }
    	
    	sd = getSearchDateAsLPMUser(sd);
    	
    	List<SvcHistDto> svcHistList = null;
    	try {
    		svcHistList = svcHistService.selectSvcHist(sd);
    	} catch (Exception e) {
    		errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
    	
    	
        List<JSONObject> entities = new ArrayList<JSONObject>();
        for (SvcHistDto n : svcHistList) {
            JSONObject entity = new JSONObject();
            entity.put("shop_nm", n.getShop_nm());
            entity.put("svc_nm", n.getSvc_nm());
            entity.put("propo_dt", n.getPropo_dt());
            entity.put("propo_seq", n.getPropo_seq());
            entity.put("file_url", n.getFile_url());
            entities.add(entity);
        }
        
        //로그
        responseLog(log_seq, new Gson().toJson(entities));
        
        return new ResponseEntity<List<JSONObject>>(entities, HttpStatus.OK);
    }
    
    // 정비명세서 마스터 조회
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/repair-main", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<JSONObject>> RepairMainInfo(HttpServletRequest request, @RequestBody @Valid RepairMainDto rmd, Errors errors, @CurrentUser Account currentUser) throws Exception {
    	//로그
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(rmd));
    	
    	repairMainValidator.validate(rmd, errors);
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
    		return badRequest(errors);
        }
    	
    	List<RepairMainDto> RepairMainList = null;
    	try {
    		RepairMainList = svcHistService.selectSRepairMain(rmd);
    	} catch (Exception e) {
    		errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
    	
    	
        List<JSONObject> entities = new ArrayList<JSONObject>();
        for (RepairMainDto n : RepairMainList) {
            JSONObject entity = new JSONObject();
            entity.put("shop_cd", n.getShop_cd());
            entity.put("propo_dt", n.getPropo_dt());
            entity.put("propo_seq", n.getPropo_seq());
            entity.put("variant_nm", n.getVariant_nm());
            entity.put("vehic_no", n.getVehic_no());
            entity.put("vin", n.getVin());
            entity.put("entry_odo", n.getEntry_odo());
            entity.put("shop_name", n.getShop_name());
            entity.put("company_address", n.getCompany_address());
            entity.put("company_phone", n.getCompany_phone());
            entity.put("sa_name", n.getSa_name());
            entity.put("entry_date", n.getEntry_date());
            entity.put("vehic_odometer", n.getVehic_odometer());
            entity.put("entry_done_date", n.getEntry_done_date());
            entity.put("entry_add_maintainance", n.getEntry_add_maintainance());
            entity.put("entry_realease_date", n.getEntry_realease_date());
            entity.put("entry_estimate_happycall_date", n.getEntry_estimate_happycall_date());
            entity.put("entry_next_maintanace_date", n.getEntry_next_maintanace_date());
            entity.put("parts_service_price1", n.getParts_service_price1());
            entity.put("parts_price", n.getParts_price());
            entity.put("parts_service_price2", n.getParts_service_price2());
            entity.put("parts_total_price", n.getParts_total_price());
            entity.put("minus_fms_price", n.getMinus_fms_price());
            entity.put("minus_guarantee_price", n.getMinus_guarantee_price());
            entity.put("minus_deposit_price", n.getMinus_deposit_price());
            entity.put("minus_etc_price", n.getMinus_etc_price());
            entity.put("minus_total_price", n.getMinus_total_price());
            entity.put("sub_total_price", n.getSub_total_price());
            entity.put("vat_price", n.getVat_price());
            entity.put("total_price", n.getTotal_price());
            entities.add(entity);
        }
        
        //로그
        responseLog(log_seq, new Gson().toJson(entities));
        
        return new ResponseEntity<List<JSONObject>>(entities, HttpStatus.OK);
    }
    
    // 정비명세서 상세 조회
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/repair-detail", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<JSONObject>> RepairDetailInfo(HttpServletRequest request, @RequestBody @Valid RepairDetailDto rdd, Errors errors, @CurrentUser Account currentUser) throws Exception {
    	//로그
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(rdd));
    	
    	repairDetailValidator.validate(rdd, errors);
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
    		return badRequest(errors);
        }
    	
    	List<RepairDetailDto> RepairDetailList = null;
    	try {
    		RepairDetailList = svcHistService.selectSRepairDetail(rdd);
    	} catch (Exception e) {
    		errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
    	
        List<JSONObject> entities = new ArrayList<JSONObject>();
        for (RepairDetailDto n : RepairDetailList) {
            JSONObject entity = new JSONObject();
            entity.put("shop_cd", n.getShop_cd());
            entity.put("propo_dt", n.getPropo_dt());
            entity.put("propo_seq", n.getPropo_seq());
            entity.put("job_account_code", n.getJob_account_code());
            entity.put("job_account", n.getJob_account());
            entity.put("job_section", n.getJob_section());
            entity.put("job_index", n.getJob_index());
            entity.put("job_code", n.getJob_code());
            entity.put("job_quantity", n.getJob_quantity());
            entity.put("job_time", n.getJob_time());
            entity.put("job_dc", n.getJob_dc());
            entity.put("job_price", n.getJob_price());
            entity.put("job_total_price", n.getJob_total_price());
            entity.put("job_claim_price", n.getJob_claim_price());
            entities.add(entity);
        }
        
        //로그
        responseLog(log_seq, new Gson().toJson(entities));
        
        return new ResponseEntity<List<JSONObject>>(entities, HttpStatus.OK);
    }
}
