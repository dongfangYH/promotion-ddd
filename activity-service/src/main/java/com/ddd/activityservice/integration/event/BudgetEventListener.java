package com.ddd.activityservice.integration.event;

import cn.hutool.json.JSONUtil;
import com.ddd.common.domain.event.BudgetCreateEvent;
import com.ddd.common.domain.event.PrizeCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BudgetEventListener {

    @KafkaListener(topics = "budget-event", groupId = "budget-activity-g")
    public void handleBudgetCreatedEvent(String msg){
        BudgetCreateEvent event = JSONUtil.toBean(msg, BudgetCreateEvent.class);
        log.info("receive budget event : {}", event);
    }
}
