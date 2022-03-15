package se.app.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.mapper.app.CustomerMapper;

@Service
public class CustomerService {
 
    @Autowired
    CustomerMapper customerMapper;
    
    public CustomerDto selectCustomer(CustomerDto customers) throws Exception{
        return customerMapper.selectCustomer(customers);
    }
}