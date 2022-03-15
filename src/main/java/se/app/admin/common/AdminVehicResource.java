package se.app.admin.common;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class AdminVehicResource extends EntityModel<AdminVehicDto> {
    
    public AdminVehicResource(AdminVehicDto svcHist, Link... links) {
        super(svcHist, links);
    }
}
