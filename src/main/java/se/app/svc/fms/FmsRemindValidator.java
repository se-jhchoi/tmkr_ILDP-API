package se.app.svc.fms;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import se.common.SearchDateDto;

@Component
public class FmsRemindValidator {

    public void validate(FmsRemindDto fms, Errors errors) {
    	if ("".equals(fms.getVin()) || null == fms.getVin()) {
            errors.reject("002", "Empty Parameter : vin");
        }
    }
}
