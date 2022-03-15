package se.app.customer.associate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
// 002 : Empty Parameter, 003 : Invalid Parameter, 004 : Empty Result, 005 : Invalid Result
public class AssociateValidator {

    public void validate(AssociateDto associateDto, Errors errors, String type) {
    	if(type.equals("certify")) {
    		if ("".equals(associateDto.getSearch_type()) || null == associateDto.getSearch_type()) {
    			errors.reject("002", "Empty Parameter : search_type");
    			return;
    		}
    		if(associateDto.getSearch_type().equals("D")) {
	    		if ("".equals(associateDto.getDlr_contract_no()) || null == associateDto.getDlr_contract_no()) {
	                errors.reject("002", "Empty Parameter : dlr_contract_no");
	                return;
	            }
	    		if ("".equals(associateDto.getHp_no()) || null == associateDto.getHp_no()) {
	                errors.reject("002", "Empty Parameter : hp_no");
	                return;
	            }
    		}
    		if(associateDto.getSearch_type().equals("C")) {
	    		if ("".equals(associateDto.getHp_no()) || null == associateDto.getHp_no()) {
	                errors.reject("002", "Empty Parameter : hp_no");
	                return;
	            }
	    		
	    		if ("".equals(associateDto.getCust_nm()) || null == associateDto.getCust_nm()) {
	                errors.reject("002", "Empty Parameter : cust_nm");
	                return;
	            }
    		}
    	} else if(type.equals("main")) {
    		if ("".equals(associateDto.getSearch_type()) || null == associateDto.getSearch_type()) {
    			errors.reject("002", "Empty Parameter : search_type");
    			return;
    		}
    		if(associateDto.getSearch_type().equals("D")) {
	    		if ("".equals(associateDto.getDlr_contract_no()) || null == associateDto.getDlr_contract_no()) {
	                errors.reject("002", "Empty Parameter : dlr_contract_no");
	                return;
	            }
    		}
    		if(associateDto.getSearch_type().equals("C")) {
	    		if ("".equals(associateDto.getHp_no()) || null == associateDto.getHp_no()) {
	                errors.reject("002", "Empty Parameter : hp_no");
	                return;
	            }
	    		
	    		if ("".equals(associateDto.getCust_nm()) || null == associateDto.getCust_nm()) {
	                errors.reject("002", "Empty Parameter : cust_nm");
	                return;
	            }
    		}
    	}
    }
}
