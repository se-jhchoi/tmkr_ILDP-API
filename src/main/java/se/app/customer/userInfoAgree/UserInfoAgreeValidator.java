package se.app.customer.userInfoAgree;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class UserInfoAgreeValidator {

    public void validate(UserInfoAgreeDto cust, Errors errors) {
    	if ("".equals(cust.getLpm_user_no()) || null == cust.getLpm_user_no()) {
            errors.reject("002", "Empty Parameter : lpm_user_no");
            return;
        }
    	
    	if ("".equals(cust.getAgree_type()) || null == cust.getAgree_type()) {
            errors.reject("002", "Empty Parameter : agree_type");
            return;
        }
    	
    	if ("".equals(cust.getAgree_st_dt()) || null == cust.getAgree_st_dt()) {
            errors.reject("002", "Empty Parameter : agree_st_dt");
            return;
        }
    	
    	if ("".equals(cust.getAgree_end_dt()) || null == cust.getAgree_end_dt()) {
            errors.reject("002", "Empty Parameter : agree_end_dt");
            return;
        }
    }
}
