package com.ddd.common.interfaces.rest.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddBudgetsRequestDTO {
    @NotNull
    private String activityNO;
    @NotNull
    private String prizeNO;
    @NotEmpty
    private List<BudgetDetailDTO> budgetDetailDTOList;
}
