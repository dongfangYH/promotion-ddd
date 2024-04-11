package com.ddd.common.domain.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
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
