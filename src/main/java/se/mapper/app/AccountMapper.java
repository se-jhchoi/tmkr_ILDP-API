package se.mapper.app;
 
import org.springframework.stereotype.Repository;

import se.common.accounts.Account;
 
@Repository
public interface AccountMapper {
 
	public Account selectAccountInfo(String username) throws Exception;
    
}