package se.app.customer.associate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.mapper.app.AssociateMapper;

@Service
public class AssociateService {
 
    @Autowired
    AssociateMapper associateMapper;
    
    public AssociateResultDto selectAssociateCertify(AssociateDto associate) throws Exception{
        return associateMapper.selectAssociateCertify(associate);
    }
    
    public List<AssociateInfoDto> selectAssociateInfo(AssociateDto associate) throws Exception{
        return associateMapper.selectAssociateInfo(associate);
    }
}