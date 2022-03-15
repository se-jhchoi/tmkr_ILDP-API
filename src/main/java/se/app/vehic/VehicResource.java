package se.app.vehic;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class VehicResource extends EntityModel<VehicDto> {
    
    public VehicResource(VehicDto vehic, Link... links) {
        super(vehic, links);
    }
}
