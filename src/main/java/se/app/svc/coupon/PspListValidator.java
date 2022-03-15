package se.app.svc.coupon;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class PspListValidator {

    public void validate(PspListDto fms, Errors errors) {
    	if ("".equals(fms.getVin()) || null == fms.getVin()) {
            errors.reject("002", "Empty Parameter : vin");
        }
    }

}
