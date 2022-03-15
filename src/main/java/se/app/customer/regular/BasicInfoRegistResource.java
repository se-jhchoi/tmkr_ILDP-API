package se.app.customer.regular;

import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class BasicInfoRegistResource extends EntityModel<BasicInfoRegistDto> {
    
    public BasicInfoRegistResource(BasicInfoRegistDto basicInfo, Link... links) {
        super(basicInfo, links);
    }
}
