package se.app.customer.userInfoAgree;

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

import se.app.customer.active.CustomerActiveDto;
import se.app.customer.active.CustomerActiveResource;
import se.app.customer.active.CustomerActiveValidator;
import se.app.svc.resv.RemindReactionDto;
import se.app.svc.resv.RemindReactionResource;
import se.common.CommonConst;
import se.common.CommonController;
import se.common.ErrorsResource;
import se.common.accounts.Account;
import se.common.accounts.CurrentUser;

@Controller
@RequestMapping(value = "/app/customer/userinfoagree", produces = MediaTypes.HAL_JSON_VALUE)
public class UserInfoAgreeController extends CommonController{
	
    private final UserInfoAgreeValidator userInfoAgreeValidator;

    public UserInfoAgreeController(UserInfoAgreeValidator userInfoAgreeValidator) {
        this.userInfoAgreeValidator = userInfoAgreeValidator;
    }
    
    // 개인정보동의 등록
    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "/regist", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity userInfoAgree(HttpServletRequest request, 
    									@RequestBody @Valid UserInfoAgreeDto agree,
    									Errors errors,
    									@CurrentUser Account currentUser) throws Exception {
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(agree));
    	
    	userInfoAgreeValidator.validate(agree, errors);
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
            return badRequest(errors);
        }
    	
    	try {
    		insertInterfaceMaster(CommonConst.KEY_USERINFO_AGREE, new Gson().toJson(agree));
		} catch (Exception e) {
			errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
        
    	UserInfoAgreeResource agreeResource = new UserInfoAgreeResource(agree);
    	
        responseLog(log_seq, new Gson().toJson(agreeResource.getContent()));

        return ResponseEntity.ok(agreeResource);
    }
}
