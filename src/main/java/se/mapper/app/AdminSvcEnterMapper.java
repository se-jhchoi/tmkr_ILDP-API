package se.mapper.app;
 
import java.util.List;

import org.springframework.stereotype.Repository;

import se.app.admin.svcEnter.AdminSvcEnterDto;
 
@Repository
public interface AdminSvcEnterMapper {
	
    public List<AdminSvcEnterDto> selectSvcEnterList(AdminSvcEnterDto svcEnter) throws Exception;
    
}