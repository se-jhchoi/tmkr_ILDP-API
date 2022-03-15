package se.mapper.app;
 
import java.util.List;

import org.springframework.stereotype.Repository;

import se.app.svc.RepairDetailDto;
import se.app.svc.RepairMainDto;
import se.app.svc.SvcHistDto;
import se.common.SearchDateDto;
 
@Repository
public interface SvcHistMapper {
	
    public List<SvcHistDto> selectSvcHist(SearchDateDto sd) throws Exception;
    
    public List<RepairMainDto> selectSRepairMain(RepairMainDto rmd) throws Exception;
    
    public List<RepairDetailDto> selectSRepairDetail(RepairDetailDto rdd) throws Exception;
}