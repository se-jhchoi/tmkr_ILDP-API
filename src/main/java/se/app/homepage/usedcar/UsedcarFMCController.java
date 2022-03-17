package se.app.homepage.usedcar;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.app.homepage.ApiException;
import se.app.homepage.ApiResponseEntity;
import se.app.homepage.ApiStatusEnum;
import se.common.*;
import se.common.accounts.Account;
import se.common.accounts.CurrentUser;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/ext/usedcar")
public class UsedcarFMCController {

    private final Logger logger = LoggerFactory.getLogger(UsedcarFMCController.class);
    private final UsedcarFMCService ufs;
    private final CommonService cs;

    public UsedcarFMCController(UsedcarFMCService ufs, CommonService cs) {
        this.ufs = ufs;
        this.cs = cs;
    }

    @PostMapping(value = "/fmc_request")
    public ResponseEntity<?> freeMaintenanceCampaignRequest(
            HttpServletRequest request,
            @RequestBody @Valid UsedcarFMCRequestDto ufo,
            @CurrentUser Account currentUser
    ) {

        Integer log_seq;

        // 1.Request Logging
        try {
            log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(ufo));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiException(ApiStatusEnum.DATABASE_EXCEPTION);
        }

        // 2.Call Service
        try {

            ufs.registerUsedcarFMCRequest(ufo);
            insertInterfaceMaster(CommonConst.KEY_UCAR_FMC_REQUEST, new Gson().toJson(ufo));

        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiException(ApiStatusEnum.DATABASE_EXCEPTION);
        }
        if ( ufo.getRequest_number() == null || ufo.getRequest_number() == 0) {
            throw new ApiException(ApiStatusEnum.DATABASE_EXCEPTION);
        }

        // 3.Response Logging
        try {
            responseLog(log_seq, new Gson().toJson(ufo));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiException(ApiStatusEnum.DATABASE_EXCEPTION);
        }

        return ResponseEntity
                .status(ApiStatusEnum.SUCCESS.getStatus())
                .body(ApiResponseEntity.builder()
                        .code(ApiStatusEnum.SUCCESS.getCode())
                        .message(ApiStatusEnum.SUCCESS.getMessage())
                        .data(ufo)
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
