package se.app.vehic;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class VehicValidator {

    public void validate(VehicDto vehic, Errors errors) {
    	if ("".equals(vehic.getVin()) || null == vehic.getVin()) {
            errors.reject("002", "Empty Parameter : vin");
        }
    }
}
