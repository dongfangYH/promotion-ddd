package com.ddd.budgetservice.infrastructure.messaging;

import cn.hutool.json.JSONUtil;
import com.ddd.budgetservice.integration.event.BudgetEventPublisher;
import com.ddd.common.domain.event.BudgetCreateEvent;
import jakarta.annotation.Resource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class BudgetEventPublisherImpl implements BudgetEventPublisher {

    @Resource
    private KafkaTemplate<Object, Object> template;

    @Override
    public void budgetCreated(BudgetCreateEvent event) {
        event.setEventType("BUDGET_CREATED");
        template.send("budget-event", JSONUtil.toJsonStr(event));
    }
}
