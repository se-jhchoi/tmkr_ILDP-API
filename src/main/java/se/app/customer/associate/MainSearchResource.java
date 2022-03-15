package se.app.customer.associate;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class MainSearchResource extends EntityModel<AssociateInfoDto> {
    
    public MainSearchResource(AssociateInfoDto associateResultDto, Link... links) {
        super(associateResultDto, links);
    }
}
