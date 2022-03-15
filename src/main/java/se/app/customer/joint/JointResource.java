package se.app.customer.joint;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class JointResource extends EntityModel<JointDto> {
    
    public JointResource(JointDto joint, Link... links) {
        super(joint, links);
    }
}
