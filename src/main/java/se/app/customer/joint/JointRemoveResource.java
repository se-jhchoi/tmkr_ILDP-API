package se.app.customer.joint;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class JointRemoveResource extends EntityModel<JointRemoveDto> {
    
    public JointRemoveResource(JointRemoveDto joint, Link... links) {
        super(joint, links);
    }
}
