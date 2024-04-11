package com.ddd.common.domain.event;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class PrizeCreatedEvent extends DomainEvent{

    private String prizeNO;
    public PrizeCreatedEvent(String eventId, Date eventTime) {
        super(eventId, eventTime);
    }
}
