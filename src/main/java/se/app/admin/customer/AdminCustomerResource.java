package se.app.admin.customer;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class AdminCustomerResource extends EntityModel<AdminCustomerDto> {
    
    public AdminCustomerResource(AdminCustomerDto showRoom, Link... links) {
        super(showRoom, links);
    }
}
