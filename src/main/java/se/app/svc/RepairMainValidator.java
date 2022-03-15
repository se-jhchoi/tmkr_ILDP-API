package se.app.svc;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import se.common.SearchDateDto;

@Component
public class RepairMainValidator {

    public void validate(RepairMainDto rmd, Errors errors) {
    	if ("".equals(rmd.getShop_cd()) || null == rmd.getShop_cd()) {
            errors.reject("002", "Empty Parameter : shop_cd");
        }
    	
    	if ("".equals(rmd.getPropo_dt()) || null == rmd.getPropo_dt()) {
            errors.reject("002", "Empty Parameter : propo_dt");
        }
    	
    	if ("".equals(rmd.getPropo_seq()) || null == rmd.getPropo_seq()) {
            errors.reject("002", "Empty Parameter : propo_seq");
        }
    }
}
