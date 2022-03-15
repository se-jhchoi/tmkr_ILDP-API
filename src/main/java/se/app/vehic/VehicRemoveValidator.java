package se.app.vehic;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class VehicRemoveValidator {

    public void validate(VehicRemoveDto vehic, Errors errors) {
    	if ("".equals(vehic.getLpm_user_no()) || null == vehic.getLpm_user_no()) {
            errors.reject("002", "Empty Parameter : lpm_user_no");
            return;
        }
    	
    	if ("".equals(vehic.getVin()) || null == vehic.getVin()) {
            errors.reject("002", "Empty Parameter : vin");
            return;
        }
    	
    	if ("".equals(vehic.getRemove_reason()) || null == vehic.getRemove_reason()) {
            errors.reject("002", "Empty Parameter : remove_reason");
            return;
        }
    }
}
