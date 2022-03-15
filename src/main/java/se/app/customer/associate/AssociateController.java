package se.app.customer.associate;

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
import se.app.customer.regular.RegularDto;
import se.common.CommonController;
import se.common.accounts.Account;
import se.common.accounts.CurrentUser;

@Controller
@RequestMapping(value = "/app/customer/associate", produces = MediaTypes.HAL_JSON_VALUE)
public class AssociateController extends CommonController{
	@Autowired
    AssociateService associateService;

    private final AssociateValidator associatesValidator;

    public AssociateController(AssociateValidator associatesValidator) {
        this.associatesValidator = associatesValidator;
    }
    
    // 준회원 인증
    @RequestMapping(value = "/certify", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity customerAssociateCertify(HttpServletRequest request, 
												   @RequestBody @Valid AssociateDto associate,
												   Errors errors,
												   @CurrentUser Account currentUser) throws Exception {
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(associate));
    	
    	associatesValidator.validate(associate, errors, "certify");
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
            return badRequest(errors);
        }
    	
    	AssociateResultDto associateResult = associateService.selectAssociateCertify(associate);
        
		if (associateResult == null) { 
			errors.reject("003", "Empty Result");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
			return badRequest(errors);
		}
		

        AssociateResource associatesResource = new AssociateResource(associateResult);
        
        responseLog(log_seq, new Gson().toJson(associatesResource.getContent()));

        return ResponseEntity.ok(associatesResource);
    }
    
    // 준회원 메인 정보
    @RequestMapping(value = "/main/search", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity customerAssociateInfo(HttpServletRequest request, @RequestBody @Valid AssociateDto associate,
												Errors errors,
												@CurrentUser Account currentUser) throws Exception {
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(associate));
    	
    	associatesValidator.validate(associate, errors, "main");
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errors));
            return badRequest(errors);
        }
    	
    	List<AssociateInfoDto> associateInfo = null;
    	try {    		
    		associateInfo = associateService.selectAssociateInfo(associate);
    	} catch (Exception e) {
    		errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
    	
    	List<JSONObject> entities = new ArrayList<JSONObject>();
        for (AssociateInfoDto n : associateInfo) {
            JSONObject entity = new JSONObject();
            entity.put("cust_nm", n.getCust_nm());
            entity.put("brand_nm", n.getBrand_nm());
            entity.put("model_nm", n.getModel_nm());
            entity.put("variant_nm", n.getVariant_nm());
            entity.put("model_year", n.getModel_year());
            entity.put("sfx_nm", n.getSfx_nm());
            entity.put("col_combi_cd", n.getCol_combi_cd());
            entity.put("col_combi_nm", n.getCol_combi_nm());
            entity.put("contract_dt", n.getContract_dt());
            entity.put("contract_url", n.getContract_url());
            entity.put("delivery_plan_dt", n.getDelivery_plan_dt());
            entity.put("contract_stat_cd", n.getContract_stat_cd());
            entity.put("contract_stat_nm", n.getContract_stat_nm());
            entity.put("sc_nm", n.getSc_nm());
            entity.put("sc_grp_cd", n.getSc_grp_cd());
            entity.put("sc_grp_nm", n.getSc_grp_nm());
            entity.put("sc_addr", n.getSc_addr());
            entity.put("sc_tell_no", n.getSc_tell_no());
            entity.put("dlr_contract_no", n.getDlr_contract_no());
            entity.put("dealer_id", n.getDealer_id());
            
            entities.add(entity);
        }

		responseLog(log_seq, new Gson().toJson(entities));

        return new ResponseEntity<List<JSONObject>>(entities, HttpStatus.OK);
    }
}
