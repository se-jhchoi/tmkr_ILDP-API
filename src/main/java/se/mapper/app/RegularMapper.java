package se.mapper.app;
 
import java.util.List;

import org.springframework.stereotype.Repository;

import se.app.customer.regular.RegularDto;
import se.app.customer.regular.RegularRegistDto;
import se.common.Param2Dto;
 
@Repository
public interface RegularMapper {
	
    public List<RegularDto> selectRegularVehicInfo(RegularDto regular) throws Exception;
    
    public List<RegularDto> selectRegularVehicInfo4PASSKEY(RegularDto regular) throws Exception;
    
    public int selectLPMUserCnt(String lpm_user_no) throws Exception;
    
    public Param2Dto selectCiCustInvalidCnt(RegularRegistDto regular) throws Exception;
    
    public void insertLPMVehicUseInfo(RegularDto param) throws Exception;
    
    public void insertLPMVehicUseInfo(RegularRegistDto param) throws Exception;
}