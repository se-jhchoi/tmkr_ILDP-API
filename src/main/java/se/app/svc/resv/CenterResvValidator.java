package se.app.svc.resv;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class CenterResvValidator {

    public void validate(CenterResvDto resvDto, Errors errors) {
    	if ("".equals(resvDto.getShop_cd()) || null == resvDto.getShop_cd()) {
            errors.reject("002", "Empty Parameter : shop_cd");
        }
    	
    	if ("".equals(resvDto.getReal_resv_date()) || null == resvDto.getReal_resv_date()) {
            errors.reject("002", "Empty Parameter : real_resv_date");
        }
    }
}
