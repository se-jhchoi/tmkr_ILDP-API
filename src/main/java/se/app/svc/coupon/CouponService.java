package se.app.svc.coupon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.mapper.app.SvcCouponMapper;

@Service
public class CouponService {
 
    @Autowired
    SvcCouponMapper SvcCouponMapper;
    
    public List<FmsListDto> selectFmsList(FmsListDto coupon) throws Exception{
        return SvcCouponMapper.selectFmsList(coupon);
    }
    
    public List<FmsListDto> selectPromotionFmsList(FmsListDto coupon) throws Exception{
        return SvcCouponMapper.selectPromotionFmsList(coupon);
    }
    public List<PspListDto> selectPspList(PspListDto coupon) throws Exception{
        return SvcCouponMapper.selectPspList(coupon);
    }
}