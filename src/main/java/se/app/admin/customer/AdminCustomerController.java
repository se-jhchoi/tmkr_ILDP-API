package se.app.admin.customer;

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
@RequestMapping(value = "/app/admin/customer", produces = MediaTypes.HAL_JSON_VALUE)
public class AdminCustomerController extends CommonController{
	@Autowired
    AdminCustomerService adminCustomerService;

    private final AdminCustomerValidator adminCustomerValidator;
    
    public AdminCustomerController(AdminCustomerValidator adminCustomerValidator) {
        this.adminCustomerValidator = adminCustomerValidator;
    }
    
    // 고객 목록 호출
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<JSONObject>> allVehicList(HttpServletRequest request, @RequestBody @Valid AdminCustomerDto customer, Errors errors, @CurrentUser Account currentUser) throws Exception {
    	//로그
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(customer));
    	
    	adminCustomerValidator.validate(customer, errors);
    	
    	if (errors.hasErrors()) {
            return badRequest(errors);
        }
    	
    	List<AdminCustomerDto> adminCustomerList = adminCustomerService.selectCustomerList(customer);
    	
        List<JSONObject> entities = new ArrayList<JSONObject>();
        for (AdminCustomerDto n : adminCustomerList) {
            JSONObject entity = new JSONObject();
            entity.put("lpm_user_no", n.getLpm_user_no());
            entity.put("cust_nm", n.getCust_nm());
            entity.put("hp", n.getHp());
            entity.put("vin", n.getVin());
            entity.put("last_retail_sales_dt", n.getLast_retail_sales_dt());
            entity.put("group_name", n.getGroup_name());
            entities.add(entity);
        }
        
        //로그
        responseLog(log_seq, new Gson().toJson(entities));
        
        return new ResponseEntity<List<JSONObject>>(entities, HttpStatus.OK);
    }
}
