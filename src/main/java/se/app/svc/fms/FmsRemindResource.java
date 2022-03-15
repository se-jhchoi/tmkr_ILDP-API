package se.app.svc.fms;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class FmsRemindResource extends EntityModel<FmsRemindDto> {
    
    public FmsRemindResource(FmsRemindDto svcHist, Link... links) {
        super(svcHist, links);
    }
}
