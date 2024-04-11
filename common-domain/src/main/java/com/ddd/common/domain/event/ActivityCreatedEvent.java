package com.ddd.common.domain.event;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ActivityCreatedEvent extends DomainEvent{
    private String activityNo;
    public ActivityCreatedEvent(String eventId, Date eventTime) {
        super(eventId, eventTime);
    }
}
