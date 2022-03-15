package se.app.admin.svcEnter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.mapper.app.AdminSvcEnterMapper;

@Service
public class AdminSvcEnterService {
 
    @Autowired
    AdminSvcEnterMapper adminSvcEnterMapper;
    
    public List<AdminSvcEnterDto> selectSvcEnterList(AdminSvcEnterDto svcEnter) throws Exception{
        return adminSvcEnterMapper.selectSvcEnterList(svcEnter);
    }
}