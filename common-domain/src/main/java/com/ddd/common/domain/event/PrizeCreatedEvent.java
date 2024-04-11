package com.ddd.common.domain.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Setter
@Getter
public class PrizeCreatedEvent extends DomainEvent{

    private String prizeNO;
    public PrizeCreatedEvent(String eventId, Date eventTime) {
        super(eventId, eventTime);
    }
}
