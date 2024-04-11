package com.ddd.prizeservice.infrastructure.messaging;

import cn.hutool.json.JSONUtil;
import com.ddd.common.domain.event.PrizeCreatedEvent;
import com.ddd.prizeservice.integration.event.PrizeEventPublisher;
import jakarta.annotation.Resource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PrizeEventPublisherImpl implements PrizeEventPublisher {

    @Resource
    private KafkaTemplate<Object, Object> template;

    @Override
    public void prizeCreated(PrizeCreatedEvent event) {
        event.setEventType("PRIZE_CREATED");
        template.send("prize-event", JSONUtil.toJsonStr(event));
    }
}
