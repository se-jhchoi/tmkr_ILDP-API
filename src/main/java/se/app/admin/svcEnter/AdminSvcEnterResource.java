package se.app.admin.svcEnter;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class AdminSvcEnterResource extends EntityModel<AdminSvcEnterDto> {
    
    public AdminSvcEnterResource(AdminSvcEnterDto showRoom, Link... links) {
        super(showRoom, links);
    }
}
