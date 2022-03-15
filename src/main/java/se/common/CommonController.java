package se.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;

@Controller
public class CommonController {
	@Autowired
    CommonService commonService;
	
	 public Integer insertInterfaceMaster(String if_type, String if_data) throws Exception {
		InterfaceMasterDto interfaceMasterDto = new InterfaceMasterDto();
		interfaceMasterDto.setIf_type(if_type);
		interfaceMasterDto.setIf_data(if_data);
		
		return commonService.insertInterfaceMaster(interfaceMasterDto);
    }
	
    public Integer requestLog(HttpServletRequest request, String req_userid, String params) throws Exception {
    	RequestLogDto requestLogDto = new RequestLogDto();
    	requestLogDto.setReq_user_id(req_userid);
		requestLogDto.setReq_protocol(request.getProtocol());
		requestLogDto.setReq_contexttype(request.getContentType());
		requestLogDto.setReq_method(request.getMethod());
		requestLogDto.setReq_path(request.getRequestURI());
		requestLogDto.setReq_data(params);
		
		commonService.insertRequestLog(requestLogDto);
		
		return requestLogDto.getLog_seq();
    }
    
    public void responseLog(Integer log_seq, String params) throws Exception {
		ResponseLogDto responseLogDto = new ResponseLogDto();
		responseLogDto.setLog_seq(log_seq);
		responseLogDto.setRes_data(params);
		commonService.updateRequestLog(responseLogDto);
    }
    
    public void responseLog(Integer log_seq, String params, Exception e) throws Exception {
    	ResponseLogDto responseLogDto = new ResponseLogDto();
		responseLogDto.setLog_seq(log_seq);
		responseLogDto.setRes_data(params);
		responseLogDto.setSys_log(getPrintStackTrace(e));
		commonService.updateRequestLog(responseLogDto);
    }
    
    
	public ResponseEntity badRequest(Errors errors) {
        return ResponseEntity.badRequest().body(errors);
    }
	
	public static String getPrintStackTrace(Exception e) {
        
        StringWriter errors = new StringWriter();
        e.printStackTrace(new PrintWriter(errors));
         
        return errors.toString();
    }
	
	@SuppressWarnings("unchecked")
	public JSONObject errorSerialize(Errors errors) throws IOException {
		JSONObject jsonObject = new JSONObject();
        errors.getGlobalErrors().forEach(e -> {
        	jsonObject.put("error", e.getCode());
        	jsonObject.put("message", e.getDefaultMessage());
        });
        
        return jsonObject;
    }
	
	public SearchDateDto getSearchDateAsLPMUser(SearchDateDto sd) throws Exception {
		SearchDateDto sd2 = new SearchDateDto();
		
		int UCAR_CNT = commonService.selectUCarCHK(sd);
		
		if(UCAR_CNT == 0) {
			sd2 = commonService.selectSearchDataAsLPMUser1(sd);
		}else {
			sd2 = commonService.selectSearchDataAsLPMUser2(sd);
		}
		
		if(sd2 != null) {
			if(sd2.getStart_dt() != null && !"".equals(sd2.getStart_dt())) {
				sd.setStart_dt(sd2.getStart_dt());
			}
			
			if(sd2.getEnd_dt() != null && !"".equals(sd2.getEnd_dt())) {
				sd.setEnd_dt(sd2.getEnd_dt());
			}
		}
		
        return sd;
    }
}
