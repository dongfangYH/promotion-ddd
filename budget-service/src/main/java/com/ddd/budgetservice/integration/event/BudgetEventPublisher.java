package com.ddd.budgetservice.integration.event;

import com.ddd.common.domain.event.BudgetCreateEvent;

public interface BudgetEventPublisher {

    void budgetCreated(BudgetCreateEvent event);
}
