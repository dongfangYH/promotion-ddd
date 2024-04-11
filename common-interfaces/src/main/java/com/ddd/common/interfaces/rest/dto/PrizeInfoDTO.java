package com.ddd.common.interfaces.rest.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PrizeInfoDTO {

    @NotNull
    private String activityNO;
    @NotNull
    private String name;
    private String prizeNO;
    private String description;
    @Positive
    @NotNull
    private Integer value;
    private List<BudgetInfoDTO> budgetInfoDTOList;
}
