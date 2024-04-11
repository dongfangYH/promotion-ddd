package com.ddd.common.domain.event;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class DomainEvent {

    private String eventId;
    private String eventType;
    private Date eventTime;

    public DomainEvent(String eventId, Date eventTime) {
        this.eventId = eventId;
        this.eventTime = eventTime;
    }
}
