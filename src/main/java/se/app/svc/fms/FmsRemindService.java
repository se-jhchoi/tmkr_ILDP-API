package se.app.svc.fms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.mapper.app.FmsRemindMapper;

@Service
public class FmsRemindService {
 
    @Autowired
    FmsRemindMapper fmsRemindMapper;
    
    public List<FmsRemindDto> selectFmsRemindList(FmsRemindDto fms) throws Exception{
        return fmsRemindMapper.selectFmsRemindList(fms);
    }
}