package se.mapper.app;
 
import java.util.List;

import org.springframework.stereotype.Repository;

import se.app.svc.odometer.OdometerDto;
import se.common.SearchDateDto;
 
@Repository
public interface OdometerMapper {
	
    public List<OdometerDto> selectOdometerList(SearchDateDto sd) throws Exception;
}