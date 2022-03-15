package se.mapper.app;
 
import java.util.List;

import org.springframework.stereotype.Repository;

import se.app.customer.associate.AssociateDto;
import se.app.customer.associate.AssociateInfoDto;
import se.app.customer.associate.AssociateResultDto;
 
@Repository
public interface AssociateMapper {
 
    public AssociateResultDto selectAssociateCertify(AssociateDto associate) throws Exception;
    
    public List<AssociateInfoDto> selectAssociateInfo(AssociateDto associate) throws Exception;
}