package se.app.svc.resv;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class RemindReactionValidator {

    public void validate(RemindReactionDto resvDto, Errors errors) {
    	if ("".equals(resvDto.getVin()) || null == resvDto.getVin()) {
            errors.reject("002", "Empty Parameter : vin");
        }
    	
    	if ("".equals(resvDto.getShop_cd()) || null == resvDto.getShop_cd()) {
            errors.reject("002", "Empty Parameter : shop_cd");
        }
    	
    	if ("".equals(resvDto.getResv_dt()) || null == resvDto.getResv_dt()) {
            errors.reject("002", "Empty Parameter : resv_dt");
        }
    	
    	if ("".equals(resvDto.getResv_seq()) || null == resvDto.getResv_seq()) {
            errors.reject("002", "Empty Parameter : resv_seq");
        }
    	
    	
    	if ("".equals(resvDto.getRemind_reaction()) || null == resvDto.getRemind_reaction()) {
            errors.reject("002", "Empty Parameter : remind_reaction");
        }
    }
}
