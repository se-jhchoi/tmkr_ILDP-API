package se.app.svc.odometer;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class OdometerResource extends EntityModel<OdometerDto> {
    
    public OdometerResource(OdometerDto odometer, Link... links) {
        super(odometer, links);
    }
}
