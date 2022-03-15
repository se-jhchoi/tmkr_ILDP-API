package se.app.vehic;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import se.common.CommonConst;
import se.common.CommonController;
import se.common.accounts.Account;
import se.common.accounts.CurrentUser;

@Controller
@RequestMapping(value = "/app/vehic", produces = MediaTypes.HAL_JSON_VALUE)
public class VehicController extends CommonController{
	@Autowired
    VehicService vehicService;

    private final VehicValidator vehicValidator;
    private final VehicRemoveValidator vehicRemoveValidator;

    public VehicController(VehicValidator vehicValidator, VehicRemoveValidator vehicRemoveValidator) {
        this.vehicValidator = vehicValidator;
        this.vehicRemoveValidator = vehicRemoveValidator;
    }
    
    // 차량정보
	@RequestMapping(value = "/search", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity vehicInfo(HttpServletRequest request, @RequestBody @Valid VehicDto vehic, Errors errors, @CurrentUser Account currentUser) throws Exception {
    	//로그
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(vehic));
    	
    	vehicValidator.validate(vehic, errors);
    	
    	if (errors.hasErrors()) {
            return badRequest(errors);
        }
    	
    	VehicDto VehicInfo = vehicService.selectVehicInfo(vehic);
    	
    	VehicResource vehicResource = new VehicResource(VehicInfo);
    	
        //로그
        responseLog(log_seq, new Gson().toJson(vehicResource.getContent()));
        
        return ResponseEntity.ok(vehicResource);
    }
	
	// 차량 제거
	@RequestMapping(value = "/remove", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity vehicRemove(HttpServletRequest request, @RequestBody @Valid VehicRemoveDto vehic, Errors errors, @CurrentUser Account currentUser) throws Exception {
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(vehic));
    	
    	vehicRemoveValidator.validate(vehic, errors);
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
            return badRequest(errors);
        }
    	
    	try {
    		int vehicCnt = vehicService.selectVehicCnt(vehic);
    		if(vehicCnt==0) {
    			errors.reject("003", "Empty Result : 고객회원번호와 차대번호와 매칭되는 정보가 없습니다.");
    		}
		} catch (Exception e) {
			errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
            return badRequest(errors);
        }
    	
    	try {
    		insertInterfaceMaster(CommonConst.KEY_VEHIC_REMOVE, new Gson().toJson(vehic));
		} catch (Exception e) {
			errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
    	
    	VehicRemoveResource vehicRemoveResource = new VehicRemoveResource(vehic);
    	
        responseLog(log_seq, new Gson().toJson(vehicRemoveResource.getContent()));
        
        return ResponseEntity.ok(vehicRemoveResource);
    }
}
