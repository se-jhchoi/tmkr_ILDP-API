package se.app.svc.odometer;

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
@RequestMapping(value = "/app/svc/odometer", produces = MediaTypes.HAL_JSON_VALUE)
public class OdometerController extends CommonController{
	@Autowired
    OdometerService odometerService;

    private final OdometerValidator odometerValidator;

    public OdometerController(OdometerValidator odometerValidator) {
        this.odometerValidator = odometerValidator;
    }
    
    // 주행거리 조회
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<JSONObject>> odometerRegularInfo(HttpServletRequest request, @RequestBody @Valid SearchDateDto sd, Errors errors, @CurrentUser Account currentUser) throws Exception {
    	//로그
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(sd));
    	
    	odometerValidator.validate(sd, errors);
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
    		return badRequest(errors);
        }
    	
    	sd = getSearchDateAsLPMUser(sd);
    	
    	List<OdometerDto> odometerList = odometerService.selectOdometerList(sd);
    	
        List<JSONObject> entities = new ArrayList<JSONObject>();
        for (OdometerDto n : odometerList) {
            JSONObject entity = new JSONObject();
            entity.put("vin", n.getVin());
            entity.put("shop_nm", n.getShop_nm());
            entity.put("odometer", n.getOdometer());
            entity.put("reg_dt", n.getReg_dt());
            entities.add(entity);
        }
        
        //로그
        responseLog(log_seq, new Gson().toJson(entities));
        
        return new ResponseEntity<List<JSONObject>>(entities, HttpStatus.OK);
    }
}
