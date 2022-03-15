package se.mapper.app;
 
import java.util.List;

import org.springframework.stereotype.Repository;

import se.app.admin.vehic.AdminVehicDto;
 
@Repository
public interface AdminVehicMapper {
	
    public List<AdminVehicDto> selectVehicList(AdminVehicDto vehic) throws Exception;
    
}