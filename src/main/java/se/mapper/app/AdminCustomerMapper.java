package se.mapper.app;
 
import java.util.List;

import org.springframework.stereotype.Repository;

import se.app.admin.customer.AdminCustomerDto;
 
@Repository
public interface AdminCustomerMapper {
	
    public List<AdminCustomerDto> selectCustomerList(AdminCustomerDto customer) throws Exception;
    
}