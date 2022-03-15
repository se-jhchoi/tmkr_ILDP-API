package se.app.svc;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import se.common.SearchDateDto;

@Component
public class SvcHistValidator {

    public void validate(SearchDateDto sd, Errors errors) {
    	if ("".equals(sd.getVin()) || null == sd.getVin()) {
            errors.reject("002", "Empty Parameter : vin");
        }
    	
    	if ("".equals(sd.getLpm_user_no()) || null == sd.getLpm_user_no()) {
            errors.reject("002", "Empty Parameter : lpm_user_no");
        }
    }
}
