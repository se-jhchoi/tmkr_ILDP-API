package se.app.customer.joint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.common.Param2Dto;
import se.mapper.app.JointMapper;

@Service
public class JointService {
    @Autowired
    JointMapper jointMapper;
    
    public Param2Dto selectJointInvalidChk(JointDto joint) throws Exception{
        return jointMapper.selectJointInvalidChk(joint);
    }
    
    public Param2Dto selectJointRemoveInvalidChk(JointRemoveDto joint) throws Exception{
        return jointMapper.selectJointRemoveInvalidChk(joint);
    }
}