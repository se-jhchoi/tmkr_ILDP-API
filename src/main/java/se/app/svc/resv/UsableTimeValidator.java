package se.app.svc.resv;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class UsableTimeValidator {

    public void validate(UsableTimeDto resvDto, Errors errors) {
    	if ("".equals(resvDto.getShop_cd()) || null == resvDto.getShop_cd()) {
            errors.reject("002", "Empty Parameter : shop_cd");
        }
    	
    	if ("".equals(resvDto.getResv_date()) || null == resvDto.getResv_date()) {
            errors.reject("002", "Empty Parameter : resv_date");
        }
    }
}
