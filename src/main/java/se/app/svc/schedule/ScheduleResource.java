package se.app.svc.schedule;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class ScheduleResource extends EntityModel<ScheduleDto> {
    
    public ScheduleResource(ScheduleDto schedule, Link... links) {
        super(schedule, links);
    }
}
