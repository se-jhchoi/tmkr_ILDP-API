package se.app.svc.resv;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class ResvValidator {

    public void validate(ResvDto resvDto, Errors errors, String type) {
    	if(type.equals("list")) {
    		if ("".equals(resvDto.getSearch_type()) || null == resvDto.getSearch_type()) {
	            errors.reject("002", "Empty Parameter : search_type");
	            return;
	        } else {
	        	if(!resvDto.getSearch_type().equals("LIST") && !resvDto.getSearch_type().equals("DT")) {
	        		errors.reject("004", "Invalid Parameter : search_type");
		            return;
	        	}
	        }
    		
    		if(resvDto.getSearch_type().equals("DT")) {
    			if ("".equals(resvDto.getResv_dt()) || null == resvDto.getResv_dt()) {
    	            errors.reject("002", "Empty Parameter : resv_dt");
    	            return;
    	        }
    		}
    		
    		if(resvDto.getSearch_type().equals("LIST")) {
    			if ("".equals(resvDto.getVin()) || null == resvDto.getVin()) {
    	            errors.reject("002", "Empty Parameter : vin");
    	            return;
    	        }
    		}
    	}
    	
    	if(type.equals("last-visit")) {
	    	if ("".equals(resvDto.getVin()) || null == resvDto.getVin()) {
	            errors.reject("002", "Empty Parameter : vin");
	            return;
	        }
    	}
    }
}
