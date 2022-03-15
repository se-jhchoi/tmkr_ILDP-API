package se.app.contract;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import se.common.CommonController;
import se.common.ErrorsResource;
import se.common.accounts.Account;
import se.common.accounts.CurrentUser;

@Controller
@RequestMapping(value = "/contract", produces = MediaTypes.HAL_JSON_VALUE)
public class ContractController extends CommonController{
	@Autowired
    ContractService contractService;

    private final ContractValidator contractValidator;

    public ContractController(ContractValidator contractValidator) {
        this.contractValidator = contractValidator;
    }
    
    // 계약 조회
    @RequestMapping(value = "/info", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity contractInfo(HttpServletRequest request, @RequestBody @Valid ContractDto contract,
    									Errors errors,
    									@CurrentUser Account currentUser
                                   ) throws Exception {
    	//로그
    	Integer log_seq = requestLog(request, currentUser.getUsername(), new Gson().toJson(contract));
    	
    	if (errors.hasErrors()) {
            return badRequest(errors);
        }
    	
    	contractValidator.validate(contract, errors);
    	
    	if (errors.hasErrors()) {
            return badRequest(errors);
        }
    	
    	contract = contractService.selectContractInfo(contract);
        
    	ContractResource contractResource = new ContractResource(contract);
    	
    	//로그
        responseLog(log_seq, new Gson().toJson(contractResource.getContent()));
        return ResponseEntity.ok(contractResource);
    }
}
