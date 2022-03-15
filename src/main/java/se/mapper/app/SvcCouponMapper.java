package se.mapper.app;
 
import java.util.List;

import org.springframework.stereotype.Repository;

import se.app.svc.coupon.FmsListDto;
import se.app.svc.coupon.PspListDto;

 
@Repository
public interface SvcCouponMapper {
 
	public List<FmsListDto> selectFmsList(FmsListDto svcDto) throws Exception;
	
	public List<FmsListDto> selectPromotionFmsList(FmsListDto svcDto) throws Exception;
	
	public List<PspListDto> selectPspList(PspListDto svcDto) throws Exception;
	
	
	
    
}