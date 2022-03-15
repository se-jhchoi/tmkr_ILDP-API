package se.app.svc.resv;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class ResvResource extends EntityModel<ResvDto> {

    public ResvResource(ResvDto resv, Link... links) {
        super(resv, links);
    }
}
