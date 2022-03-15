package se.app.svc.resv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.mapper.app.ResvMapper;

@Service
public class ResvService {
 
    @Autowired
    ResvMapper resvMapper;
    
    public List<ResvDto> selectResvList(ResvDto resv) throws Exception{
        return resvMapper.selectResvList(resv);
    }
    
    public List<ResvDto> selectResv4ResvDt(ResvDto resv) throws Exception{
        return resvMapper.selectResv4ResvDt(resv);
    }
    
    public ResvDto selectLastVisitSvc(ResvDto resv) throws Exception{
        return resvMapper.selectLastVisitSvc(resv);
    }
    
    public List<CenterResvDto> selectCenterResvInfo(CenterResvDto resv) throws Exception{
        return resvMapper.selectCenterResvInfo(resv);
    }
    
    public List<UsableTimeResultDto> selectUsableTimeList(UsableTimeDto resv) throws Exception{
        return resvMapper.selectUsableTimeList(resv);
    }
    
    public int selectResvChkResvTime(ResvRegistDto resv) throws Exception{
        return resvMapper.selectResvChkResvTime(resv);
    }
    
    public int selectResvChkDuplication(ResvRegistDto resv) throws Exception{
        return resvMapper.selectResvChkDuplication(resv);
    }
    
    public void insertResv(ResvRegistDto resv) throws Exception{
        resvMapper.insertResv(resv);
    }
    
    public void updateResvCancel(ResvCancelDto resv) throws Exception{
        resvMapper.updateResvCancel(resv);
    }
    
    public List<ResvStatusSearchDto> selectResvStatusSearch(ResvStatusSearchDto resv) throws Exception{
        return resvMapper.selectResvStatusSearch(resv);
    }
}