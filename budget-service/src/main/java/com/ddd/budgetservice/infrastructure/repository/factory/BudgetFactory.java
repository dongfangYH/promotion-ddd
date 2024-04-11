package com.ddd.budgetservice.infrastructure.repository.factory;

import com.ddd.budgetservice.domain.model.aggregate.Budget;
import com.ddd.budgetservice.infrastructure.repository.po.BudgetPO;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BudgetFactory {

    public BudgetPO createPrizePO(Budget budget){
        BudgetPO budgetPO = new BudgetPO();
        budgetPO.setBudgetNO(budget.getBudgetNO().no());
        budgetPO.setPrizeNO(budget.getPrizeNO());
        budgetPO.setBudgetType(budget.getBudgetType());
        budgetPO.setActivityNO(budget.getActivityNO());
        budgetPO.setDescription(budget.getDescription());
        budgetPO.setCreateTime(new Date());
        budgetPO.setLimit(budget.getLimit());
        return budgetPO;
    }
}
