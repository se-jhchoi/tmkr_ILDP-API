package se.app.svc.resv;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class RemindReactionResource extends EntityModel<RemindReactionDto> {

    public RemindReactionResource(RemindReactionDto resv, Link... links) {
        super(resv, links);
    }
}
