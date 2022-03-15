package se.mapper.app;
 
import java.util.List;

import org.springframework.stereotype.Repository;

import se.app.svc.schedule.ScheduleDto;
import se.common.SearchDateDto;
 
@Repository
public interface ScheduleMapper {
	
	public List<ScheduleDto> selectSvcScheduleList(SearchDateDto sd) throws Exception;
}