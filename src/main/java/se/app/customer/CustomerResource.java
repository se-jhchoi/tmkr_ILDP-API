package se.app.customer;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class CustomerResource extends EntityModel<CustomerDto> {

    public CustomerResource(CustomerDto members, Link... links) {
        super(members, links);
    }
}
