package se.app.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.common.SearchDateDto;
import se.mapper.app.SvcHistMapper;

@Service
public class SvcHistService {
 
    @Autowired
    SvcHistMapper svcHistMapper;
    
    public List<SvcHistDto> selectSvcHist(SearchDateDto sd) throws Exception{
        return svcHistMapper.selectSvcHist(sd);
    }
    
    public List<RepairMainDto> selectSRepairMain(RepairMainDto rmd) throws Exception{
        return svcHistMapper.selectSRepairMain(rmd);
    }
    
    public List<RepairDetailDto> selectSRepairDetail(RepairDetailDto rdd) throws Exception{
        return svcHistMapper.selectSRepairDetail(rdd);
    }

}