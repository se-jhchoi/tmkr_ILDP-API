package se.app.admin.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.mapper.app.AdminCommonMapper;

@Service
public class AdminCommonService {
 
    @Autowired
    AdminCommonMapper adminCommonMapper;
    
    public List<AdminVehicDto> selectVehicList() throws Exception{
        return adminCommonMapper.selectVehicList();
    }
    
    public List<AdminSvcCenterDto> selectSvcCenterList() throws Exception{
        return adminCommonMapper.selectSvcCenterList();
    }
    
    public List<AdminShowRoomDto> selectShowRoomList() throws Exception{
        return adminCommonMapper.selectShowRoomList();
    }
}