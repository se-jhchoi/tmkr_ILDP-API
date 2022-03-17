package se.app.homepage.testdrive;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import se.app.homepage.ApiException;
import se.app.homepage.ApiResponseEntity;
import se.app.homepage.ApiStatusEnum;
import se.app.homepage.CommonCodeDto;
import se.common.CommonConst;
import se.common.CommonService;
import se.common.InterfaceMasterDto;
import se.common.RequestLogDto;
import se.common.ResponseLogDto;
import se.common.accounts.Account;
import se.common.accounts.CurrentUser;

@RestController
@RequestMapping(value = "/ext/testdrive")
public class TestdriveController {
	
	private final Logger logger = LoggerFactory.getLogger(TestdriveController.class);
	private final TestdriveService tds;
	private final CommonService cs;
	
	public TestdriveController(TestdriveService tds, CommonService cs) {
		this.tds = tds;
		this.cs = cs;
	}

	@PostMapping(value = "/request")
	public ResponseEntity<?> request(
	    	HttpServletRequest request, 
			@RequestBody @Valid TestdriveRequestDto tdo,
			@CurrentUser Account currentUser    	
	) {
    	
    	Integer log_seq;
    	
    	// 1.Request Logging
    	try {
    		log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(tdo));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApiException(ApiStatusEnum.DATABASE_EXCEPTION);
		}
    	
		String brand = tdo.getBrand_cd();
		if ( StringUtils.equals(brand, "T")) {
			//if ( StringUtils.isBlank(tdo.getThmp_td_client_id()) || StringUtils.isBlank(tdo.getThmp_td_url())) {
			if ( StringUtils.isBlank(tdo.getThmp_td_url())) {
				throw new ApiException(ApiStatusEnum.VALIDATION_EXCEPTION);
			}
		}    	
    	
    	// 2.Call Service
    	try {
    		
    		tds.registerRequest(tdo);
    		insertInterfaceMaster(CommonConst.KEY_TESTDRIVE_REQUEST, new Gson().toJson(tdo));

		} catch (Exception e) {
			e.printStackTrace();
			throw new ApiException(ApiStatusEnum.DATABASE_EXCEPTION);
		}
    	if ( tdo.getRequest_number() == null || tdo.getRequest_number() == 0) {
    		throw new ApiException(ApiStatusEnum.DATABASE_EXCEPTION);
    	}
    	
    	// 3.Response Logging
        try {
			responseLog(log_seq, new Gson().toJson(tdo));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApiException(ApiStatusEnum.DATABASE_EXCEPTION);
		}
        
		return ResponseEntity
				.status(ApiStatusEnum.SUCCESS.getStatus())
				.body(ApiResponseEntity.builder()
						.code(ApiStatusEnum.SUCCESS.getCode())
						.message(ApiStatusEnum.SUCCESS.getMessage())
						.data(tdo)
						.build());
	}
	
    @Autowired
    PasswordEncoder passwordEncoder;

	@PostMapping(value = "/codelist")
	public ResponseEntity<?> codelist(
	    	HttpServletRequest request,
			@RequestBody @Valid CommonCodeDto cco,
			@CurrentUser Account currentUser    	
	) {
    	
    	Integer log_seq;
    	List<CommonCodeDto> codes;
    	
//    	toyota_hp
//    	toyotano1baT7UGFsny
//    	{bcrypt}$2a$10$gqhoX4iapzX1nzE1OD6s1.Qt7jAoASE7JUEGbqPTrW.kJKwplrevG
//
//    	lexus_hp
//    	lexusno1dyKhGtTR4g
//    	{bcrypt}$2a$10$neWp1Baf1YBgJ/PZouqSF.O0MIwo9cWOnZ3BW2BYiuw7SWSHWIYGy
    	
    	//logger.info("toyota_hp : " + passwordEncoder.encode("toyotano1baT7UGFsny"));
    	//logger.info("lexus_hp : " + passwordEncoder.encode("lexusno1dyKhGtTR4g"));
    	
    	// 1.Request Logging
    	try {
    		log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(cco));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApiException(ApiStatusEnum.DATABASE_EXCEPTION);
		}
    	
    	// 2.Call Service
    	try {
    		if ( cco.getCode_type().equals("SHOP")) {
				codes = tds.searchShop(cco);
			} else if ( cco.getCode_type().equals("CENTER")) {
				codes = tds.searchCenter(cco);
    		} else {
    			codes = tds.searchCommonCode(cco);
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApiException(ApiStatusEnum.DATABASE_EXCEPTION);
		}
    	
    	// 3.Response Logging
        try {
			responseLog(log_seq, new Gson().toJson(codes));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApiException(ApiStatusEnum.DATABASE_EXCEPTION);
		}
        
		return ResponseEntity
				.status(ApiStatusEnum.SUCCESS.getStatus())
				.body(ApiResponseEntity.builder()
						.code(ApiStatusEnum.SUCCESS.getCode())
						.message(ApiStatusEnum.SUCCESS.getMessage())
						.data(codes)
						.build());
	}	
	
	
	public Integer insertInterfaceMaster(String if_type, String if_data) throws Exception {
		InterfaceMasterDto interfaceMasterDto = new InterfaceMasterDto();
		interfaceMasterDto.setIf_type(if_type);
		interfaceMasterDto.setIf_data(if_data);
		
		return cs.insertInterfaceMaster(interfaceMasterDto);
   }
	
   public Integer requestLog(HttpServletRequest request, String req_userid, String params) throws Exception {
   	RequestLogDto requestLogDto = new RequestLogDto();
   	requestLogDto.setReq_user_id(req_userid);
		requestLogDto.setReq_protocol(request.getProtocol());
		requestLogDto.setReq_contexttype(request.getContentType());
		requestLogDto.setReq_method(request.getMethod());
		requestLogDto.setReq_path(request.getRequestURI());
		requestLogDto.setReq_data(params);
		
		cs.insertRequestLog(requestLogDto);
		
		return requestLogDto.getLog_seq();
   }
   
   public void responseLog(Integer log_seq, String params) throws Exception {
		ResponseLogDto responseLogDto = new ResponseLogDto();
		responseLogDto.setLog_seq(log_seq);
		responseLogDto.setRes_data(params);
		cs.updateRequestLog(responseLogDto);
   }
	
}
