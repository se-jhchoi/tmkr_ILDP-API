package se.mapper.app;
 
import java.util.List;

import org.springframework.stereotype.Repository;

import se.app.svc.resv.CenterResvDto;
import se.app.svc.resv.ResvCancelDto;
import se.app.svc.resv.ResvDto;
import se.app.svc.resv.ResvRegistDto;
import se.app.svc.resv.ResvStatusSearchDto;
import se.app.svc.resv.UsableTimeDto;
import se.app.svc.resv.UsableTimeResultDto;
 
@Repository
public interface ResvMapper {
    public List<ResvDto> selectResvList(ResvDto resv) throws Exception;
    
    public List<ResvDto> selectResv4ResvDt(ResvDto resv) throws Exception;
    
    public ResvDto selectLastVisitSvc(ResvDto resv) throws Exception;
    
    public List<CenterResvDto> selectCenterResvInfo(CenterResvDto resv) throws Exception;
    
    public List<UsableTimeResultDto> selectUsableTimeList(UsableTimeDto resv) throws Exception;
    
    public int selectResvChkResvTime(ResvRegistDto resv) throws Exception;
    
    public int selectResvChkDuplication(ResvRegistDto resv) throws Exception;
    
    public void insertResv(ResvRegistDto resv) throws Exception;
    
    public void updateResvCancel(ResvCancelDto resv) throws Exception;
    
    public List<ResvStatusSearchDto> selectResvStatusSearch(ResvStatusSearchDto resv) throws Exception;
}