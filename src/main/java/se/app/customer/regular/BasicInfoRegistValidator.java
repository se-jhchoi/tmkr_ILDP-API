package se.app.customer.regular;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class BasicInfoRegistValidator {

    public void validate(BasicInfoRegistDto basicInfo, Errors errors) {
    	if ("".equals(basicInfo.getLpm_user_no()) || null == basicInfo.getLpm_user_no()) {
            errors.reject("002", "Empty Parameter : lpm_user_no");
            return;
        }
    }
}
