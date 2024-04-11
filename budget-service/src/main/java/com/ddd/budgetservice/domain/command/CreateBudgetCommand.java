package com.ddd.budgetservice.domain.command;

import com.ddd.common.domain.enums.BudgetType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreateBudgetCommand {
    private String budgetNO;
    private Integer limit;
    private String activityNO;
    private String prizeNO;
    private BudgetType budgetType;
    private String description;

}
