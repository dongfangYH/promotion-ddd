package com.ddd.common.domain.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Setter
@Getter
public class ActivityCreatedEvent extends DomainEvent{
    private String activityNo;
    public ActivityCreatedEvent(String eventId, Date eventTime) {
        super(eventId, eventTime);
    }
}
