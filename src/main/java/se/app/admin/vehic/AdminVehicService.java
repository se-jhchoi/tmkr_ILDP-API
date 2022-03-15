package se.app.admin.vehic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.mapper.app.AdminVehicMapper;

@Service
public class AdminVehicService {
 
    @Autowired
    AdminVehicMapper adminVehicMapper;
    
    public List<AdminVehicDto> selectVehicList(AdminVehicDto customer) throws Exception{
        return adminVehicMapper.selectVehicList(customer);
    }
}