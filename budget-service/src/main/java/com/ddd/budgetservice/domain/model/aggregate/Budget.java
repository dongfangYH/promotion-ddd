package com.ddd.budgetservice.domain.model.aggregate;

import com.ddd.budgetservice.domain.command.CreateBudgetCommand;
import com.ddd.budgetservice.domain.model.valueobject.BudgetNO;
import com.ddd.common.domain.enums.BudgetType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Budget {

    private BudgetNO budgetNO;
    private Integer limit;
    private String activityNO;
    private String prizeNO;
    private BudgetType budgetType;
    private String description;

    public Budget(CreateBudgetCommand command){
        this.budgetNO = new BudgetNO(command.getBudgetNO());
        this.activityNO = command.getActivityNO();
        this.limit = command.getLimit();
        this.prizeNO = command.getPrizeNO();
        this.budgetType = command.getBudgetType();
        this.description = command.getDescription();
    }
}
