package se.app.svc;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import se.common.SearchDateDto;

@Component
public class RepairDetailValidator {

    public void validate(RepairDetailDto rdd, Errors errors) {
    	if ("".equals(rdd.getShop_cd()) || null == rdd.getShop_cd()) {
            errors.reject("002", "Empty Parameter : shop_cd");
        }
    	
    	if ("".equals(rdd.getPropo_dt()) || null == rdd.getPropo_dt()) {
            errors.reject("002", "Empty Parameter : propo_dt");
        }
    	
    	if ("".equals(rdd.getPropo_seq()) || null == rdd.getPropo_seq()) {
            errors.reject("002", "Empty Parameter : propo_seq");
        }
    }
}
