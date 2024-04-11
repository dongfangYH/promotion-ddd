package com.ddd.budgetservice.application.commandservice;

import com.ddd.budgetservice.domain.command.CreateBudgetCommand;
import com.ddd.budgetservice.domain.model.aggregate.Budget;
import com.ddd.budgetservice.domain.model.valueobject.BudgetNO;
import com.ddd.budgetservice.domain.repository.BudgetRepository;
import com.ddd.budgetservice.integration.event.BudgetEventPublisher;
import com.ddd.common.domain.event.BudgetCreateEvent;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BudgetCommandService {


    private BudgetRepository budgetRepository;

    @Resource
    private BudgetEventPublisher budgetEventPublisher;

    public BudgetCommandService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public BudgetNO addBudget(CreateBudgetCommand command){
        command.setBudgetNO(UUID.randomUUID().toString());

        Budget budget = new Budget(command);
        budgetRepository.save(budget);

        BudgetCreateEvent event = new BudgetCreateEvent(budget.getBudgetNO().no(), new Date());
        budgetEventPublisher.budgetCreated(event);

        return budget.getBudgetNO();
    }

    public List<BudgetNO> addBudgets(List<CreateBudgetCommand> commandList) {
        return commandList.stream().map(command -> addBudget(command)).collect(Collectors.toList());
    }
}
