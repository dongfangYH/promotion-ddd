package com.ddd.activityservice.domain.model.entity;

import com.ddd.common.domain.enums.BudgetType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BudgetInfo implements Cloneable{

    private BudgetType budgetType;

    private String description;
    private Integer limit;

    @Override
    public Object clone() throws CloneNotSupportedException {
        BudgetInfo cloneBudget = (BudgetInfo) super.clone();
        cloneBudget.setLimit(this.limit);
        return cloneBudget;
    }
}
