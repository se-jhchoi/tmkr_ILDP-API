package se.app.admin.vehic;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class AdminVehicResource extends EntityModel<AdminVehicDto> {
    
    public AdminVehicResource(AdminVehicDto showRoom, Link... links) {
        super(showRoom, links);
    }
}
