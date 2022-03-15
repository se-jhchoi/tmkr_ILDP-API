package se.app.admin.vehic;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class AdminVehicValidator {

    public void validate(AdminVehicDto vehic, Errors errors) {
    	if ("".equals(vehic.getVin()) || null == vehic.getVin()) {
            errors.reject("002", "Empty Parameter : vin");
        }
    }
}
