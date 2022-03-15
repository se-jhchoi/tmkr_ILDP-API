package se.app.svc.resv;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class ResvCancelResource extends EntityModel<ResvCancelDto> {

    public ResvCancelResource(ResvCancelDto resv, Link... links) {
        super(resv, links);
    }
}
