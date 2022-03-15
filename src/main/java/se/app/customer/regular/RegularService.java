package se.app.customer.regular;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.common.Param2Dto;
import se.mapper.app.RegularMapper;

@Service
public class RegularService {
 
    @Autowired
    RegularMapper regularMapper;
    
    public List<RegularDto> selectRegularVehicInfo(RegularDto regular) throws Exception{
        return regularMapper.selectRegularVehicInfo(regular);
    }
    
    public List<RegularDto> selectRegularVehicInfo4PASSKEY(RegularDto regular) throws Exception{
        return regularMapper.selectRegularVehicInfo4PASSKEY(regular);
    }
    
    public int selectLPMUserCnt(String lpm_user_no) throws Exception{
        return regularMapper.selectLPMUserCnt(lpm_user_no);
    }
    
    public Param2Dto selectCiCustInvalidCnt(RegularRegistDto regular) throws Exception{
        return regularMapper.selectCiCustInvalidCnt(regular);
    }
    
    public void insertLPMVehicUseInfo(RegularRegistDto param) throws Exception{
    	regularMapper.insertLPMVehicUseInfo(param);
    }
}