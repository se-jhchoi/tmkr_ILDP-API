package se.app.svc.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.common.SearchDateDto;
import se.mapper.app.ScheduleMapper;

@Service
public class ScheduleService {
 
    @Autowired
    ScheduleMapper scheduleMapper;
    
    public List<ScheduleDto> selectSvcScheduleList(SearchDateDto sd) throws Exception{
        return scheduleMapper.selectSvcScheduleList(sd);
    }
}