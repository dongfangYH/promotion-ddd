package com.ddd.prizeservice.integration.event;

import com.ddd.common.domain.event.PrizeCreatedEvent;

public interface PrizeEventPublisher {

    void prizeCreated(PrizeCreatedEvent event);
}
