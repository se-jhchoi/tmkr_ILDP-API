package se.app.customer.regular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import se.common.CommonService;
import se.common.Param2Dto;

@Component
public class RegularRegistValidator {
	@Autowired
    RegularService regularService;
	
	@Autowired
    CommonService commonService;

    public void validate(RegularRegistDto regular, Errors errors) throws Exception {
    	if ("".equals(regular.getCust_nm()) || null == regular.getCust_nm()) {
            errors.reject("002", "Empty Parameter : cust_nm");
            return;
        }
    	
    	if ("".equals(regular.getHp_no()) || null == regular.getHp_no()) {
            errors.reject("002", "Empty Parameter : hp_no");
            return;
        }
    	
    	if ("".equals(regular.getVin()) || null == regular.getVin()) {
            errors.reject("002", "Empty Parameter : vin");
            return;
        }
    	
    	if ("".equals(regular.getDlr_contract_no()) || null == regular.getDlr_contract_no()) {
            errors.reject("002", "Empty Parameter : dlr_contract_no");
            return;
        }
    	
    	if ("".equals(regular.getLpm_user_no()) || null == regular.getLpm_user_no()) {
            errors.reject("002", "Empty Parameter : lpm_user_no");
            return;
        }
    	
    	if ("".equals(regular.getLpm_reg_dt()) || null == regular.getLpm_reg_dt()) {
            errors.reject("002", "Empty Parameter : lpm_reg_dt");
            return;
        }
    	
    	if ("".equals(regular.getPass_key()) || null == regular.getPass_key()) {
            errors.reject("002", "Empty Parameter : pass_key");
            return;
        }
    	
    	
    	int lpmDupliCnt = commonService.selectLPMDupliChk(regular.getLpm_user_no());
		if(lpmDupliCnt>0) {
			errors.reject("003", "Invalid Result : 이미 등록된 LPM 회원번호입니다.");
			return;
		}
		
		Param2Dto param2 = regularService.selectCiCustInvalidCnt(regular);
		//param1 = 통합고객 CNT
		if(param2.getParam1() == 0) {
			errors.reject("003", "Invalid Result : 일치하는 DMS 통합고객 없습니다.");
			return;
		}
		
		if(param2.getParam2() > 0) {
			errors.reject("003", "Invalid Result : 이미 해당 통합고객으로 가입된 Lexus Lounge 회원이 존재합니다.");
			return;
		}
		
		if(param2.getParam3() == 0) {
			errors.reject("003", "Invalid Result : 고객과 차량이 매칭되지 않습니다. 관리자에 문의바랍니다.");
			return;
		}
    }
}
