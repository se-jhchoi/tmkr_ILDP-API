package se.app.admin.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.mapper.app.AdminCustomerMapper;

@Service
public class AdminCustomerService {
 
    @Autowired
    AdminCustomerMapper adminCustomerMapper;
    
    public List<AdminCustomerDto> selectCustomerList(AdminCustomerDto customer) throws Exception{
        return adminCustomerMapper.selectCustomerList(customer);
    }
}