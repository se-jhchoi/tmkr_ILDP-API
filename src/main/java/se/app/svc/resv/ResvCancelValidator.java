package se.app.svc.resv;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class ResvCancelValidator {

    public void validate(ResvCancelDto resvDto, Errors errors) {
    	if ("".equals(resvDto.getVin()) || null == resvDto.getVin()) {
            errors.reject("002", "Empty Parameter : vin");
            return;
        }
    	
    	if ("".equals(resvDto.getCancel_reason()) || null == resvDto.getCancel_reason()) {
            errors.reject("002", "Empty Parameter : cancel_reason");
            return;
        }
    }
}
