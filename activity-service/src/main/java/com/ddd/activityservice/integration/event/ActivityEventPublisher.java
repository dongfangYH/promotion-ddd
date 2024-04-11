package com.ddd.activityservice.integration.event;

import com.ddd.common.domain.event.ActivityCreatedEvent;

public interface ActivityEventPublisher {

    void activityCreated(ActivityCreatedEvent event);
}
