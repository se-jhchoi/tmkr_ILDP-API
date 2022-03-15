package se.app.admin.common;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class AdminShowRoomResource extends EntityModel<AdminShowRoomDto> {
    
    public AdminShowRoomResource(AdminShowRoomDto showRoom, Link... links) {
        super(showRoom, links);
    }
}
