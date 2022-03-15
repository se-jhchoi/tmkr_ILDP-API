package se.app.svc.resv;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class ResvStatusSearchValidator {

    public void validate(ResvStatusSearchDto resvDto, Errors errors) {
    	if ("".equals(resvDto.getVin()) || null == resvDto.getVin()) {
            errors.reject("002", "Empty Parameter : vin");
        }
    }
}
