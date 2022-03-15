package se.app.customer.regular;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class RegularValidator {

    public void validate(RegularDto regular, Errors errors) {
    	if("".equals(regular.getSearch_type()) || null == regular.getSearch_type()) {
    		errors.reject("002", "Empty Parameter : search_type");
            return;
    	}else {
//    		if(!regular.getSearch_type().equals("HC") &&
//    			!regular.getSearch_type().equals("HV") &&
//    			!regular.getSearch_type().equals("V") &&
//    			!regular.getSearch_type().equals("CI")) {
//    			errors.reject("003", "Invalid Parameter : search_type : "+regular.getSearch_type());
//	            return;
//    		}
    		
    		if(regular.getSearch_type().equals("HC")) {
    			if ("".equals(regular.getCust_nm()) || null == regular.getCust_nm()) {
    	            errors.reject("002", "Empty Parameter : cust_nm");
    	            return;
    	        }
    			
    			if ("".equals(regular.getHp_no()) || null == regular.getHp_no()) {
    	            errors.reject("002", "Empty Parameter : hp_no");
    	            return;
    	        }
    		} else if(regular.getSearch_type().equals("HV")) {
    			if ("".equals(regular.getHp_no()) || null == regular.getHp_no()) {
    	            errors.reject("002", "Empty Parameter : hp_no");
    	            return;
    	        }
    			
    			if (("".equals(regular.getVehic_no()) || null == regular.getVehic_no()) &&	
    	    			("".equals(regular.getVin()) || null == regular.getVin())
    	    																	) {
    	            errors.reject("002", "Empty Parameter : vin or vehic_no");
    	            return;
    	        }
    		} else if(regular.getSearch_type().equals("CI")) {
    			if ("".equals(regular.getPass_key()) || null == regular.getPass_key()) {
    	            errors.reject("002", "Empty Parameter : pass_key");
    	            return;
    	        }
    		} else {
    			errors.reject("003", "Invalid Parameter : search_type");
                return;
    		}
    	}
    }
}
