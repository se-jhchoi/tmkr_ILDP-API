package se.app.customer.active;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import se.app.customer.regular.RegularService;
import se.common.CommonService;
import se.common.Param2Dto;

@Component
public class CustomerActiveValidator {
	@Autowired
    CommonService commonService;
	
	@Autowired
	RegularService regularService;

    public void validate(CustomerActiveDto cust, Errors errors) throws Exception {
    	if ("".equals(cust.getLpm_user_no()) || null == cust.getLpm_user_no()) {
            errors.reject("002", "Empty Parameter : lpm_user_no");
            return;
        }
    	
    	if ("".equals(cust.getActive_cd()) || null == cust.getActive_cd()) {
            errors.reject("002", "Empty Parameter : active_cd");
            return;
        }
    	
    	if ("".equals(cust.getActive_data()) || null == cust.getActive_data()) {
            errors.reject("002", "Empty Parameter : active_data");
            return;
        }
    	
    	int lpmUserCnt = commonService.selectLPMUserYCnt(cust.getLpm_user_no());
		if(lpmUserCnt==0) {
			errors.reject("003", "Invalid Result : 회원정보를 찾을 수 없습니다.");
			return;
		}
    }
}
