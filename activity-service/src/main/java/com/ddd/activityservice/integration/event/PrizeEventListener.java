package com.ddd.activityservice.integration.event;

import cn.hutool.json.JSONUtil;
import com.ddd.common.domain.event.PrizeCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PrizeEventListener {

    @KafkaListener(topics = "prize-event", groupId = "prize-activity-g")
    public void handlePrizeCreatedEvent(String msg){
        PrizeCreatedEvent prizeEvent = JSONUtil.toBean(msg, PrizeCreatedEvent.class);
        log.info("receive prize event : {}", prizeEvent);
    }
}
