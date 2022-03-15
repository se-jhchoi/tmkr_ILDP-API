package se.app.customer.associate;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class AssociateResource extends EntityModel<AssociateResultDto> {
    
    public AssociateResource(AssociateResultDto associateResultDto, Link... links) {
        super(associateResultDto, links);
    }
}
