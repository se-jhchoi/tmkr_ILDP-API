package se.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.mapper.app.CommonMapper;

@Service
public class CommonService {
 
    @Autowired
    CommonMapper commonMapper;
    
    public Integer insertRequestLog(RequestLogDto param) throws Exception{
    	return commonMapper.insertRequestLog(param);
    }
    
    public void updateRequestLog(ResponseLogDto param) throws Exception{
    	commonMapper.updateRequestLog(param);
    }
    
    public Integer insertInterfaceMaster(InterfaceMasterDto param) throws Exception{
    	return commonMapper.insertInterfaceMaster(param);
    }
    
    public Integer selectUCarCHK(SearchDateDto param) throws Exception{
    	return commonMapper.selectUCarCHK(param);
    }
    
    public SearchDateDto selectSearchDataAsLPMUser1(SearchDateDto param) throws Exception{
    	return commonMapper.selectSearchDataAsLPMUser1(param);
    }
    
    public SearchDateDto selectSearchDataAsLPMUser2(SearchDateDto param) throws Exception{
    	return commonMapper.selectSearchDataAsLPMUser2(param);
    }
    
    public int selectLPMUserYCnt(String param) throws Exception{
        return commonMapper.selectLPMUserYCnt(param);
    }
    
    public int selectLPMUpUserY(LpmUserChkDto param) throws Exception{
    	return commonMapper.selectLPMUpUserYN(param);
    }
    
    public int selectLPMDupliChk(String param) throws Exception{
        return commonMapper.selectLPMDupliChk(param);
    }
}