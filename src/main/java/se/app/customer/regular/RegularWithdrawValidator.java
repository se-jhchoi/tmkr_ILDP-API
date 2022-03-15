package se.app.customer.regular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import se.common.CommonService;

@Component
public class RegularWithdrawValidator {
	@Autowired
	CommonService commonService;

    public void validate(RegularWithdrawDto regular, Errors errors) throws Exception {
    	if ("".equals(regular.getLpm_user_no()) || null == regular.getLpm_user_no()) {
            errors.reject("002", "Empty Parameter : lpm_user_no");
            return;
        }
    	
    	int lpmUserCnt = commonService.selectLPMUserYCnt(regular.getLpm_user_no());
		if(lpmUserCnt==0) {
			errors.reject("003", "Invalid Result : 회원정보를 찾을 수 없습니다.");
			return;
		}
    }
}
