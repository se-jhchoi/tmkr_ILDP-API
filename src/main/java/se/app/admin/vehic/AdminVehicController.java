package se.app.admin.vehic;

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
@RequestMapping(value = "/app/admin/vehic", produces = MediaTypes.HAL_JSON_VALUE)
public class AdminVehicController extends CommonController{
	@Autowired
    AdminVehicService adminVehicService;

    private final AdminVehicValidator adminVehicValidator;
    
    public AdminVehicController(AdminVehicValidator adminVehicValidator) {
        this.adminVehicValidator = adminVehicValidator;
    }
    
    // 차량 목록
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<JSONObject>> vehicList(HttpServletRequest request, 
													@RequestBody @Valid AdminVehicDto vehic, 
													Errors errors, 
													@CurrentUser Account currentUser) throws Exception {
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(vehic));
    	
    	adminVehicValidator.validate(vehic, errors);
    	
    	if (errors.hasErrors()) {
            return badRequest(errors);
        }
    	
    	List<AdminVehicDto> adminVehicList = adminVehicService.selectVehicList(vehic);
    	
        List<JSONObject> entities = new ArrayList<JSONObject>();
        for (AdminVehicDto n : adminVehicList) {
            JSONObject entity = new JSONObject();
            entity.put("dlr_contract_no", n.getDlr_contract_no());
            entity.put("contract_dt", n.getContract_dt());
            entity.put("brand_nm", n.getBrand_nm());
            entity.put("model_nm", n.getModel_nm());
            entity.put("variant_nm", n.getVariant_nm());
            entity.put("model_year", n.getModel_year());
            entity.put("sfx_nm", n.getSfx_nm());
            entity.put("col_combi_nm", n.getCol_combi_nm());
            entity.put("group_name", n.getGroup_name());
            entity.put("odometer", n.getOdometer());
            entity.put("recent_propo_dt", n.getRecent_propo_dt());
            entity.put("sc_nm", n.getSc_nm());
            entity.put("sc_tell_no", n.getSc_tell_no());
            entity.put("sc_hp_no", n.getSc_hp_no());
            entity.put("hybrid_yn", n.getHybrid_yn());
            
            entities.add(entity);
        }
        
        responseLog(log_seq, new Gson().toJson(entities));
        
        return new ResponseEntity<List<JSONObject>>(entities, HttpStatus.OK);
    }
}
