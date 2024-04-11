package com.ddd.common.interfaces.rest.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BudgetInfoDTO extends BudgetDetailDTO{

    @NotNull
    private String activityNO;
    @NotNull
    private String prizeNO;
}
