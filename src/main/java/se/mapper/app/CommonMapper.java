package se.mapper.app;
 
import org.springframework.stereotype.Repository;

import se.common.InterfaceMasterDto;
import se.common.LpmUserChkDto;
import se.common.RequestLogDto;
import se.common.ResponseLogDto;
import se.common.SearchDateDto;
 
@Repository
public interface CommonMapper {
	
    public Integer insertRequestLog(RequestLogDto param) throws Exception;
    
    public void updateRequestLog(ResponseLogDto param) throws Exception;
    
    public Integer insertInterfaceMaster(InterfaceMasterDto param) throws Exception;
    
    public Integer selectUCarCHK(SearchDateDto param) throws Exception;
    
    public SearchDateDto selectSearchDataAsLPMUser1(SearchDateDto param) throws Exception;
    
    public SearchDateDto selectSearchDataAsLPMUser2(SearchDateDto param) throws Exception;
    
    public Integer selectLPMUserYCnt(String param) throws Exception;
    
    public Integer selectLPMUpUserYN(LpmUserChkDto param) throws Exception;
    
    public Integer selectLPMDupliChk(String param) throws Exception;
}