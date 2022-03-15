package se.app.svc;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class SvcHistResource extends EntityModel<SvcHistDto> {
    
    public SvcHistResource(SvcHistDto svcHist, Link... links) {
        super(svcHist, links);
    }
}
