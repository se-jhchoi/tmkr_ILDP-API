package se.mapper.app;
 
import java.util.List;

import org.springframework.stereotype.Repository;

import se.app.svc.fms.FmsRemindDto;
 
@Repository
public interface FmsRemindMapper {
 
	public List<FmsRemindDto> selectFmsRemindList(FmsRemindDto fms) throws Exception;
    
}