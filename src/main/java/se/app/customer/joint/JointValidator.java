package se.app.customer.joint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import se.common.CommonService;
import se.common.Param2Dto;

@Component
public class JointValidator {
	@Autowired
    CommonService commonService;
	
	@Autowired
    JointService jointService;
	
    public void validate(JointDto joint, Errors errors) throws Exception {
    	if ("".equals(joint.getLpm_user_no()) || null == joint.getLpm_user_no()) {
            errors.reject("002", "Empty Parameter : lpm_user_no");
            return;
        }
    	
    	if ("".equals(joint.getPass_key()) || null == joint.getPass_key()) {
            errors.reject("002", "Empty Parameter : pass_key");
            return;
        }
    	
    	if ("".equals(joint.getLpm_reg_dt()) || null == joint.getLpm_reg_dt()) {
            errors.reject("002", "Empty Parameter : lpm_reg_dt");
            return;
        }
    	
    	if ("".equals(joint.getCust_nm()) || null == joint.getCust_nm()) {
            errors.reject("002", "Empty Parameter : cust_nm");
            return;
        }
    	
    	if ("".equals(joint.getHp_no()) || null == joint.getHp_no()) {
            errors.reject("002", "Empty Parameter : hp_no");
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
    	
    	int lpmDupliCnt = commonService.selectLPMDupliChk(joint.getLpm_user_no());
		if(lpmDupliCnt>0) {
			errors.reject("003", "Invalid Result : 이미 등록된 LPM 회원번호입니다.");
			return;
		}
    	
		Param2Dto param2 =  jointService.selectJointInvalidChk(joint);
		if(param2.getParam1() > 0) {
			errors.reject("005", "Invalid Result : 일치하는 DMS 통합고객 없습니다.");
			return;
		}
		if(param2.getParam2() > 0) {
			errors.reject("005", "Invalid Result : 해당 LEXUS LOUNGE 고객은 사용 중지된 사용자입니다. 관리자에 문의바랍니다. ");
			return;
		}
		if(param2.getParam3() == 0) {
			errors.reject("005", "Invalid Result : 유효한 메인고객이 아닙니다. 관리자에 문의바랍니다. ");
			return;
		}
		if(param2.getParam4() == 0) {
			errors.reject("005", "Invalid Result : 메인고객번호와 딜러번호에 일치하는 고객이 없습니다.");
			return;
		}
    }
}
