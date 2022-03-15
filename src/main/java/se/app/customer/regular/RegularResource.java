package se.app.customer.regular;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class RegularResource extends EntityModel<RegularDto> {
    
    public RegularResource(RegularDto regular, Link... links) {
        super(regular, links);
    }
}
