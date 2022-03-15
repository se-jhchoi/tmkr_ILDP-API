package se.app.admin.svcEnter;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class AdminSvcEnterValidator {

    public void validate(AdminSvcEnterDto svcEnter, Errors errors) {
    	if ("".equals(svcEnter.getShop_cd()) || null == svcEnter.getShop_cd()) {
            errors.reject("002", "Empty Parameter : shop_cd");
            return;
        }
    	
    	if ("".equals(svcEnter.getStart_dt()) || null == svcEnter.getStart_dt()) {
            errors.reject("002", "Empty Parameter : start_dt");
            return;
        }
    	
    	if ("".equals(svcEnter.getEnd_dt()) || null == svcEnter.getEnd_dt()) {
            errors.reject("002", "Empty Parameter : end_dt");
            return;
        }
    }
}
