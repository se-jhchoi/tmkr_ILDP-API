package se.app.customer.regular;

import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class RegularResultResource extends EntityModel<List<RegularDto>> {
    
    public RegularResultResource(List<RegularDto> regularList, Link... links) {
        super(regularList, links);
    }
}
