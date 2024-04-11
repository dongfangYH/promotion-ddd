package com.ddd.common.domain.event;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class BudgetCreateEvent extends DomainEvent{
    public BudgetCreateEvent(String eventId, Date eventTime) {
        super(eventId, eventTime);
    }
}
