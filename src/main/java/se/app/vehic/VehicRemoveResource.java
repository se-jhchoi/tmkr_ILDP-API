package se.app.vehic;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class VehicRemoveResource extends EntityModel<VehicRemoveDto> {
    
    public VehicRemoveResource(VehicRemoveDto vehic, Link... links) {
        super(vehic, links);
    }
}
