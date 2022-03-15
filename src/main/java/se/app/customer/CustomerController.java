package se.app.customer;

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

import se.common.CommonController;
import se.common.accounts.Account;
import se.common.accounts.CurrentUser;

@Controller
@RequestMapping(value = "/customer", produces = MediaTypes.HAL_JSON_VALUE)
public class CustomerController extends CommonController{
	@Autowired
    CustomerService customersService;

    private final CustomerValidator customerValidator;
    
    public CustomerController(CustomerValidator customerValidator) {
        this.customerValidator = customerValidator;
    }
    
    // 고객 조회
    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "/info", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity customerInfo(HttpServletRequest request, 
    									@RequestBody @Valid CustomerDto customer,
    									Errors errors,
    									@CurrentUser Account currentUser) throws Exception {
    	
    	//로그
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(customer));
    	
    	customerValidator.validate(customer, errors);
    	
    	if (errors.hasErrors()) {
            return badRequest(errors);
        }
    	
    	customer = customersService.selectCustomer(customer);
        
    	CustomerResource customerResource = new CustomerResource(customer);
    	
    	//로그
        responseLog(log_seq, new Gson().toJson(customerResource.getContent()));

        return ResponseEntity.ok(customerResource);
    }
}
