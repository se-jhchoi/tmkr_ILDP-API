package se.app.svc.resv;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class CenterResvResource extends EntityModel<CenterResvDto> {

    public CenterResvResource(CenterResvDto resv, Link... links) {
        super(resv, links);
    }
}
