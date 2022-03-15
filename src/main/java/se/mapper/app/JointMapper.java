package se.mapper.app;
 
import org.springframework.stereotype.Repository;

import se.app.customer.joint.JointDto;
import se.app.customer.joint.JointRemoveDto;
import se.common.Param2Dto;
 
@Repository
public interface JointMapper {
    public Param2Dto selectJointInvalidChk(JointDto joint) throws Exception;
 
    public Param2Dto selectJointRemoveInvalidChk(JointRemoveDto joint) throws Exception;
}