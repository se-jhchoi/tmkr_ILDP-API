package se.app.vehic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.mapper.app.VehicMapper;

@Service
public class VehicService {
 
    @Autowired
    VehicMapper vehicMapper;
    
    public VehicDto selectVehicInfo(VehicDto vehic) throws Exception{
        return vehicMapper.selectVehicInfo(vehic);
    }
    
    public int selectVehicCnt(VehicRemoveDto vehic) throws Exception{
        return vehicMapper.selectVehicCnt(vehic);
    }
}