package com.ddd.activityservice.domain.model.entity;

import cn.hutool.core.collection.CollectionUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class PrizeInfo implements Cloneable{

    private String name;
    private String prizeNO;
    private String description;
    private Integer value;
    private List<BudgetInfo> budgets;

    @Override
    public Object clone() throws CloneNotSupportedException {
        PrizeInfo clonedPrize = (PrizeInfo) super.clone();
        clonedPrize.value = this.value;
        if (CollectionUtil.isNotEmpty(budgets)){
            List<BudgetInfo> copyBudgets = new ArrayList<>();
            clonedPrize.setBudgets(copyBudgets);
            for (BudgetInfo budgetInfo : budgets){
                copyBudgets.add((BudgetInfo) budgetInfo.clone());
            }
        }

        return clonedPrize;
    }
}
