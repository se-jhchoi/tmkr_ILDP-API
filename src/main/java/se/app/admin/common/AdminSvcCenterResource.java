package se.app.admin.common;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class AdminSvcCenterResource extends EntityModel<AdminVehicDto> {
    
    public AdminSvcCenterResource(AdminVehicDto svcHist, Link... links) {
        super(svcHist, links);
    }
}
