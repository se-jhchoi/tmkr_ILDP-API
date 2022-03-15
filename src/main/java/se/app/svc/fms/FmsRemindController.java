package se.app.svc.fms;

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
@RequestMapping(value = "/app/svc/fms/fmsremind", produces = MediaTypes.HAL_JSON_VALUE)
public class FmsRemindController extends CommonController{
	@Autowired
    FmsRemindService fmsRemindService;

    private final FmsRemindValidator fmsRemindValidator;

    public FmsRemindController(FmsRemindValidator fmsRemindValidator) {
        this.fmsRemindValidator = fmsRemindValidator;
    }
    
    // FMS 잔여쿠폰 리스트
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<JSONObject>> fmsRemindRegularInfo(HttpServletRequest request, @RequestBody @Valid FmsRemindDto fms, Errors errors, @CurrentUser Account currentUser) throws Exception {
    	//로그
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(fms));
    	
    	fmsRemindValidator.validate(fms, errors);
    	
    	if (errors.hasErrors()) {
    		responseLog(log_seq, new Gson().toJson(errorSerialize(errors)));
    		return badRequest(errors);
        }
    	
    	List<FmsRemindDto> fmsRemindList = null;
    	try {
    		fmsRemindList = fmsRemindService.selectFmsRemindList(fms);
    	} catch (Exception e) {
    		errors.reject("001", "System Error");
			responseLog(log_seq, new Gson().toJson(errorSerialize(errors)), e);
            return badRequest(errors);
		}
    	
    	
        List<JSONObject> entities = new ArrayList<JSONObject>();
        for (FmsRemindDto n : fmsRemindList) {
            JSONObject entity = new JSONObject();
            entity.put("fms_remind", n.getFms_remind());
            entities.add(entity);
        }
        
        //로그
        responseLog(log_seq, new Gson().toJson(entities));
        
        return new ResponseEntity<List<JSONObject>>(entities, HttpStatus.OK);
    }
}
