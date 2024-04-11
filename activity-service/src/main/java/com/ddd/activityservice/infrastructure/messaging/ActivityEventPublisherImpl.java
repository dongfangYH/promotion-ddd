package com.ddd.activityservice.infrastructure.messaging;

import cn.hutool.json.JSONUtil;
import com.ddd.activityservice.integration.event.ActivityEventPublisher;
import com.ddd.common.domain.event.ActivityCreatedEvent;
import jakarta.annotation.Resource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ActivityEventPublisherImpl implements ActivityEventPublisher {

    @Resource
    private KafkaTemplate<Object, Object> template;

    @Override
    public void activityCreated(ActivityCreatedEvent event) {
        event.setEventType("ACTIVITY_CREATED");
        template.send("activity-event", JSONUtil.toJsonStr(event));

    }
}
