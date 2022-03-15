package se.app.admin.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import net.minidev.json.JSONObject;
import se.app.customer.regular.RegularDto;
import se.common.CommonController;
import se.common.accounts.Account;
import se.common.accounts.CurrentUser;

@Controller
@RequestMapping(value = "/app/admin/common", produces = MediaTypes.HAL_JSON_VALUE)
public class AdminCommonController extends CommonController{
	@Autowired
    AdminCommonService adminCommonService;

    private final AdminCommonVehicValidator adminVehicValidator;
    
    private final AdminSvcCenterValidator adminSvcCenterValidator;
    
    private final AdminShowRoomValidator adminShowRoomValidator;

    public AdminCommonController(AdminCommonVehicValidator adminVehicValidator, AdminSvcCenterValidator adminSvcCenterValidator, AdminShowRoomValidator adminShowRoomValidator) {
        this.adminVehicValidator = adminVehicValidator;
        this.adminSvcCenterValidator = adminSvcCenterValidator;
        this.adminShowRoomValidator = adminShowRoomValidator;
    }
    
    // 전체 차종목록
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/vehic/list", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<JSONObject>> allVehicList(HttpServletRequest request, 
    													@RequestBody @Valid AdminVehicDto adminVehic, 
    													Errors errors, 
    													@CurrentUser Account currentUser) throws Exception {
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(adminVehic));
    	
    	adminVehicValidator.validate(adminVehic, errors);
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
            return badRequest(errors);
        }
    	
    	List<AdminVehicDto> adminVehicList = null;
    	try {
    		adminVehicList = adminCommonService.selectVehicList();
    	} catch (Exception e) {
    		errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
    	
        List<JSONObject> entities = new ArrayList<JSONObject>();
        for (AdminVehicDto n : adminVehicList) {
            JSONObject entity = new JSONObject();
            entity.put("brand_nm", n.getBrand_nm());
            entity.put("model_nm", n.getModel_nm());
            entity.put("variant_nm", n.getVariant_nm());
            entity.put("model_year", n.getModel_year());
            entity.put("sfx_nm", n.getSfx_nm());
            entities.add(entity);
        }
        
        responseLog(log_seq, new Gson().toJson(entities));
        
        return new ResponseEntity<List<JSONObject>>(entities, HttpStatus.OK);
    }
    
    // 전체 서비스 센터 목록
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/svcCenter/list", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<JSONObject>> allSvcCenterList(HttpServletRequest request, 
    														@RequestBody @Valid AdminSvcCenterDto adminSvcCenter, 
    														Errors errors, 
    														@CurrentUser Account currentUser) throws Exception {
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(adminSvcCenter));
    	
    	adminSvcCenterValidator.validate(adminSvcCenter, errors);
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
            return badRequest(errors);
        }
    	
    	List<AdminSvcCenterDto> adminSvcCenterList = null;
    	try {
    		adminSvcCenterList = adminCommonService.selectSvcCenterList();
    	} catch (Exception e) {
    		errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
    	
        List<JSONObject> entities = new ArrayList<JSONObject>();
        for (AdminSvcCenterDto n : adminSvcCenterList) {
            JSONObject entity = new JSONObject();
            entity.put("group_id", n.getGroup_id());
            entity.put("group_name", n.getGroup_name());
            entities.add(entity);
        }
        
        responseLog(log_seq, new Gson().toJson(entities));
        
        return new ResponseEntity<List<JSONObject>>(entities, HttpStatus.OK);
    }
    
    // 전체 전시장 목록
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/showRoom/list", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<JSONObject>> allShowRoomList(HttpServletRequest request, 
    														@RequestBody @Valid AdminShowRoomDto adminShowRoom, 
    														Errors errors, 
    														@CurrentUser Account currentUser) throws Exception {
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(adminShowRoom));
    	
    	adminShowRoomValidator.validate(adminShowRoom, errors);
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
            return badRequest(errors);
        }
    	
    	List<AdminShowRoomDto> adminShowRoomList = null;
    	try {
    		adminShowRoomList = adminCommonService.selectShowRoomList();
    	} catch (Exception e) {
    		errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
    	
        List<JSONObject> entities = new ArrayList<JSONObject>();
        for (AdminShowRoomDto n : adminShowRoomList) {
            JSONObject entity = new JSONObject();
            entity.put("group_id", n.getGroup_id());
            entity.put("group_name", n.getGroup_name());
            entities.add(entity);
        }
        
        responseLog(log_seq, new Gson().toJson(entities));
        
        return new ResponseEntity<List<JSONObject>>(entities, HttpStatus.OK);
    }
}
