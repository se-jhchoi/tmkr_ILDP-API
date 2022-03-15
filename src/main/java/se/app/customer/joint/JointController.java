package se.app.customer.joint;

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
import se.common.Param2Dto;
import se.common.accounts.Account;
import se.common.accounts.CurrentUser;

@Controller
@RequestMapping(value = "/app/customer/joint", produces = MediaTypes.HAL_JSON_VALUE)
public class JointController extends CommonController{
	@Autowired
    JointService jointService;

	private final JointValidator jointValidator;
	
	private final JointRemoveValidator jointRemoveValidator;

    public JointController(JointValidator jointValidator, JointRemoveValidator jointRemoveValidator) {
    	this.jointValidator = jointValidator;
    	this.jointRemoveValidator = jointRemoveValidator;
    }
    
    // 공동 사용자 등록
    @RequestMapping(value = "/regist", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity customerRegularRegist(HttpServletRequest request,
    											@RequestBody @Valid JointDto joint,
    											Errors errors,
    											@CurrentUser Account currentUser) throws Exception {
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(joint));
    	
    	try {
    		jointValidator.validate(joint, errors);
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
    		insertInterfaceMaster(CommonConst.KEY_JOINT_REGIST, new Gson().toJson(joint));
		} catch (Exception e) {
			errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
        
    	JointResource jointResource = new JointResource(joint);
    	
        responseLog(log_seq, new Gson().toJson(jointResource.getContent()));
        
        return ResponseEntity.ok(jointResource);
    }
    
    // 공동 사용자 삭제
    @RequestMapping(value = "/remove", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity customerRegularWithdraw(HttpServletRequest request,
    											@RequestBody @Valid JointRemoveDto joint,
    											Errors errors,
    											@CurrentUser Account currentUser) throws Exception {
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(joint));
    	
    	try {
    		jointRemoveValidator.validate(joint, errors);
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
    		insertInterfaceMaster(CommonConst.KEY_JOINT_REMOVE, new Gson().toJson(joint));
		} catch (Exception e) {
			errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
    	
        
    	JointRemoveResource joiontRemoveResource = new JointRemoveResource(joint);
    	
        responseLog(log_seq, new Gson().toJson(joiontRemoveResource.getContent()));
        
        return ResponseEntity.ok(joiontRemoveResource);
    }

}
