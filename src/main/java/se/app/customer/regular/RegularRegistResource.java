package se.app.customer.regular;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class RegularRegistResource extends EntityModel<RegularRegistDto> {
    
    public RegularRegistResource(RegularRegistDto regular, Link... links) {
        super(regular, links);
    }
}
