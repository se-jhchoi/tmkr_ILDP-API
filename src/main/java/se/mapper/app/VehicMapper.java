package se.mapper.app;
 
import org.springframework.stereotype.Repository;

import se.app.vehic.VehicDto;
import se.app.vehic.VehicRemoveDto;
 
@Repository
public interface VehicMapper {
	
    public VehicDto selectVehicInfo(VehicDto vehic) throws Exception;
    
    public int selectVehicCnt(VehicRemoveDto vehic) throws Exception;
    
}