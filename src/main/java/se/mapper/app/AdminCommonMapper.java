package se.mapper.app;
 
import java.util.List;

import org.springframework.stereotype.Repository;

import se.app.admin.common.AdminShowRoomDto;
import se.app.admin.common.AdminSvcCenterDto;
import se.app.admin.common.AdminVehicDto;
 
@Repository
public interface AdminCommonMapper {
	
    public List<AdminVehicDto> selectVehicList() throws Exception;
    
    public List<AdminSvcCenterDto> selectSvcCenterList() throws Exception;
    
    public List<AdminShowRoomDto> selectShowRoomList() throws Exception;
}