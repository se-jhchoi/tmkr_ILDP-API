package se.app.customer.active;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class CustomerActiveResource extends EntityModel<CustomerActiveDto> {

    public CustomerActiveResource(CustomerActiveDto cust, Link... links) {
        super(cust, links);
    }
}
