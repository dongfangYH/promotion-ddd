package com.ddd.common.interfaces.rest.dto;

import com.ddd.common.domain.enums.BudgetType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BudgetDetailDTO {

    @NotNull
    private BudgetType budgetType;
    private String description;
    @NotNull
    @Positive
    private Integer limit;
}
