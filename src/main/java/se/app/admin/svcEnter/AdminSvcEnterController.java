package se.app.admin.svcEnter;

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
import se.common.CommonController;
import se.common.accounts.Account;
import se.common.accounts.CurrentUser;

@Controller
@RequestMapping(value = "/app/admin/svcEnter", produces = MediaTypes.HAL_JSON_VALUE)
public class AdminSvcEnterController extends CommonController{
	@Autowired
    AdminSvcEnterService adminSvcEnterService;

    private final AdminSvcEnterValidator adminSvcEnterValidator;
    
    public AdminSvcEnterController(AdminSvcEnterValidator adminSvcEnterValidator) {
        this.adminSvcEnterValidator = adminSvcEnterValidator;
    }
    
    // 서비스 입고 목록
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<JSONObject>> svcEnterList(HttpServletRequest request, @RequestBody @Valid AdminSvcEnterDto svcEnter, Errors errors, @CurrentUser Account currentUser) throws Exception {
    	//로그
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(svcEnter));
    	
    	adminSvcEnterValidator.validate(svcEnter, errors);
    	
    	if (errors.hasErrors()) {
            return badRequest(errors);
        }
    	
    	List<AdminSvcEnterDto> adminSvcEnterList = adminSvcEnterService.selectSvcEnterList(svcEnter);
    	
        List<JSONObject> entities = new ArrayList<JSONObject>();
        for (AdminSvcEnterDto n : adminSvcEnterList) {
            JSONObject entity = new JSONObject();
            entity.put("cust_nm", n.getCust_nm());
            entity.put("svc_type_nm", n.getSvc_type_nm());
            entity.put("propo_stat_nm", n.getPropo_stat_nm());
            entities.add(entity);
        }
        
        //로그
        responseLog(log_seq, new Gson().toJson(entities));
        
        return new ResponseEntity<List<JSONObject>>(entities, HttpStatus.OK);
    }
}
