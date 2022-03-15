package se.mapper.app;
 
import org.springframework.stereotype.Repository;

import se.app.contract.ContractDto;
 
@Repository
public interface ContractMapper {
 
	public ContractDto selectContractInfo(ContractDto contract) throws Exception;
    
}