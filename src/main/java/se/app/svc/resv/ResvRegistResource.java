package se.app.svc.resv;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class ResvRegistResource extends EntityModel<ResvRegistDto> {

    public ResvRegistResource(ResvRegistDto resv, Link... links) {
        super(resv, links);
    }
}
