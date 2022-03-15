package se.app.svc.schedule;

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
import se.common.SearchDateDto;
import se.common.accounts.Account;
import se.common.accounts.CurrentUser;

@Controller
@RequestMapping(value = "/app/svc/schedule", produces = MediaTypes.HAL_JSON_VALUE)
public class ScheduleController extends CommonController{
	@Autowired
    ScheduleService scheduleService;

    private final ScheduleValidator scheduleValidator;

    public ScheduleController(ScheduleValidator scheduleValidator) {
        this.scheduleValidator = scheduleValidator;
    }
    
    // 점검 스케줄 목록
    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity scheduleInfo(HttpServletRequest request, 
    									@RequestBody @Valid SearchDateDto sd,
    									Errors errors,
    									@CurrentUser Account currentUser) throws Exception {
    	
    	//로그
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(sd));
    	
    	scheduleValidator.validate(sd, errors);
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
    		return badRequest(errors);
        }
    	
    	sd = getSearchDateAsLPMUser(sd);
    	
    	List<ScheduleDto> svcScheduleList = scheduleService.selectSvcScheduleList(sd);
    	
        List<JSONObject> entities = new ArrayList<JSONObject>();
        for (ScheduleDto n : svcScheduleList) {
            JSONObject entity = new JSONObject();
            entity.put("vin", n.getVin());
            entity.put("shop_cd", n.getShop_cd());
            entity.put("shop_nm", n.getShop_nm());
            entity.put("svc_in_dt", n.getSvc_in_dt());
            entity.put("type_nm", n.getType_nm());
            entity.put("svc_type_nm", n.getSvc_type_nm());
            entity.put("addr", n.getAddr());
            entity.put("tel_no", n.getTel_no());
            entity.put("mng_sa_nm", n.getMng_sa_nm());
            entities.add(entity);
        }
    	
    	//로그
        responseLog(log_seq, new Gson().toJson(entities));
        
        return new ResponseEntity<List<JSONObject>>(entities, HttpStatus.OK);
    }
}
