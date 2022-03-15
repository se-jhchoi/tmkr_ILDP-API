package se.app.contract;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class ContractResource extends EntityModel<ContractDto> {

    public ContractResource(ContractDto contract, Link... links) {
        super(contract, links);
    }
}
