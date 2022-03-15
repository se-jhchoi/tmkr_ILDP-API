package se.mapper.app;
 
import org.springframework.stereotype.Repository;

import se.app.customer.CustomerDto;
 
@Repository
public interface CustomerMapper {
    public CustomerDto selectCustomer(CustomerDto customer) throws Exception;
    
}