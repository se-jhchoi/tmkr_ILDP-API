package se.app.svc.odometer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.common.SearchDateDto;
import se.mapper.app.OdometerMapper;

@Service
public class OdometerService {
 
    @Autowired
    OdometerMapper odometerMapper;
    
    public List<OdometerDto> selectOdometerList(SearchDateDto sd) throws Exception{
        return odometerMapper.selectOdometerList(sd);
    }
}