package se.app.customer.active;

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
@RequestMapping(value = "/app/customer/active", produces = MediaTypes.HAL_JSON_VALUE)
public class CustomerActiveController extends CommonController{
	
    private final CustomerActiveValidator customerActiveValidator;

    public CustomerActiveController(CustomerActiveValidator customerActiveValidator) {
        this.customerActiveValidator = customerActiveValidator;
    }
    
    // 고객활동정보
    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "/regist", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity resvRemindReaction(HttpServletRequest request, 
    									@RequestBody @Valid CustomerActiveDto cust,
    									Errors errors,
    									@CurrentUser Account currentUser) throws Exception {
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(cust));
    	
    	customerActiveValidator.validate(cust, errors);
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
            return badRequest(errors);
        }
    	
    	try {
    		insertInterfaceMaster(CommonConst.KEY_CUST_ACTIVE, new Gson().toJson(cust));
		} catch (Exception e) {
			errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
        
    	CustomerActiveResource custResource = new CustomerActiveResource(cust);
    	
        responseLog(log_seq, new Gson().toJson(custResource.getContent()));

        return ResponseEntity.ok(custResource);
    }
}
