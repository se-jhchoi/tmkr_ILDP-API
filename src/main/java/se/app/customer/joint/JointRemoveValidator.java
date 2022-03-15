package se.app.customer.joint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import se.common.Param2Dto;

@Component
public class JointRemoveValidator {
	@Autowired
    JointService jointService;

    public void validate(JointRemoveDto joint, Errors errors) throws Exception {
    	if ("".equals(joint.getLpm_user_no()) || null == joint.getLpm_user_no()) {
            errors.reject("002", "Empty Parameter : lpm_user_no");
            return;
        }
    	
    	if ("".equals(joint.getUp_lpm_user_no()) || null == joint.getUp_lpm_user_no()) {
            errors.reject("002", "Empty Parameter : up_lpm_user_no");
            return;
        }
    	
    	if ("".equals(joint.getUp_dealer_id()) || null == joint.getUp_dealer_id()) {
            errors.reject("002", "Empty Parameter : up_dealer_id");
            return;
        }
    	
    	if(joint.getLpm_user_no().equals(joint.getUp_lpm_user_no())) {
			errors.reject("003", "Invalid Parameter : 서브고객번호와 메인고객번호는 같을 수 없습니다.");
		}
		Param2Dto param2 =  jointService.selectJointRemoveInvalidChk(joint);
		if(param2.getParam1() == 0){
			errors.reject("003", "Invalid Parameter : 처리대상이 존재하지 않습니다.");
		}
    }
}
