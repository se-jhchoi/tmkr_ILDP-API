package se.app.svc.resv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import se.common.CommonService;

@Component
public class ResvRegistValidator {
	@Autowired
    CommonService commonService;

    public void validate(ResvRegistDto resvDto, Errors errors) throws Exception {
    	if ("".equals(resvDto.getLpm_user_no()) || null == resvDto.getLpm_user_no()) {
            errors.reject("002", "Empty Parameter : lpm_user_no");
            return;
        }
    	
    	if ("".equals(resvDto.getResv_cust_nm()) || null == resvDto.getResv_cust_nm()) {
            errors.reject("002", "Empty Parameter : resv_cust_nm");
            return;
        }
    	
    	if ("".equals(resvDto.getResv_hp_no()) || null == resvDto.getResv_hp_no()) {
            errors.reject("002", "Empty Parameter : resv_hp_no");
            return;
        }
    	
    	
    	if ("".equals(resvDto.getReal_resv_date()) || null == resvDto.getReal_resv_date()) {
            errors.reject("002", "Empty Parameter : real_resv_date");
            return;
        }
    	
    	if ("".equals(resvDto.getSvc_type_cd()) || null == resvDto.getSvc_type_cd()) {
            errors.reject("002", "Empty Parameter : svc_type_cd");
            return;
        } else {
        	if(!resvDto.getSvc_type_cd().equals("20") && !resvDto.getSvc_type_cd().equals("30") ) {
        		errors.reject("003", "Invalid Parameter : svc_type_cd");
                return;
        	}
        	if(resvDto.getSvc_type_cd().equals("20")) {
        		if ("".equals(resvDto.getReal_resv_st_hm()) || null == resvDto.getReal_resv_st_hm()) {
                    errors.reject("002", "Empty Parameter : real_resv_st_hm");
                    return;
                }
            	
            	if ("".equals(resvDto.getReal_resv_end_hm()) || null == resvDto.getReal_resv_end_hm()) {
                    errors.reject("002", "Empty Parameter : real_resv_end_hm");
                    return;
                }
        	} else if(resvDto.getSvc_type_cd().equals("30")) {
        		if ("".equals(resvDto.getReal_resv_st_hm()) || null == resvDto.getReal_resv_st_hm()) {
                    errors.reject("002", "Empty Parameter : real_resv_st_hm");
                    return;
                }
            	
            	if (!"".equals(resvDto.getReal_resv_end_hm()) && null != resvDto.getReal_resv_end_hm()) {
                    errors.reject("003", "Invalid Parameter : real_resv_end_hm");
                    return;
                }
        	}
        }
    	
    	if ("".equals(resvDto.getSvc_item_cd()) || null == resvDto.getSvc_item_cd()) {
            errors.reject("002", "Empty Parameter : svc_item_cd");
            return;
        }
    	
    	if ("".equals(resvDto.getSvc_item_nm()) || null == resvDto.getSvc_item_nm()) {
            errors.reject("002", "Empty Parameter : svc_item_nm");
            return;
        }
    	
    	if ("".equals(resvDto.getResv_stall_no()) || null == resvDto.getResv_stall_no()) {
            errors.reject("002", "Empty Parameter : resv_stall_no");
            return;
        }
    	
    	if ("".equals(resvDto.getShop_cd()) || null == resvDto.getShop_cd()) {
            errors.reject("002", "Empty Parameter : shop_cd");
            return;
        }
    	
    	if ("".equals(resvDto.getVin()) || null == resvDto.getVin()) {
            errors.reject("002", "Empty Parameter : vin");
            return;
        }
    	
    	int lpmUserCnt = commonService.selectLPMUserYCnt(resvDto.getLpm_user_no());
		if(lpmUserCnt==0) {
			errors.reject("003", "Invalid Result : 회원정보를 찾을 수 없습니다.");
			return;
		}
    }
}
