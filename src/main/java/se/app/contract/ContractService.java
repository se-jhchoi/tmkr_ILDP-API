package se.app.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.mapper.app.ContractMapper;

@Service
public class ContractService {
 
    @Autowired
    ContractMapper contractMapper;
    
    public ContractDto selectContractInfo(ContractDto contract) throws Exception{
        return contractMapper.selectContractInfo(contract);
    }
}