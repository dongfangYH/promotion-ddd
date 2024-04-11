package com.ddd.budgetservice.interfaces.rest.assembler;

import com.ddd.budgetservice.domain.command.CreateBudgetCommand;
import com.ddd.common.interfaces.rest.dto.AddBudgetsRequestDTO;
import com.ddd.common.interfaces.rest.dto.BudgetInfoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CreateBudgetCommandDTOAssembler {

    public static CreateBudgetCommand toCommandFromDTO(BudgetInfoDTO budgetInfoDTO){
        return new CreateBudgetCommand(null, budgetInfoDTO.getLimit(), budgetInfoDTO.getActivityNO(),
                budgetInfoDTO.getPrizeNO(), budgetInfoDTO.getBudgetType(), budgetInfoDTO.getDescription());
    }

    public static List<CreateBudgetCommand> toCommandFromDTO(AddBudgetsRequestDTO requestDTO){
        return requestDTO.getBudgetDetailDTOList().stream().map(budgetDetail -> {
            CreateBudgetCommand command = new CreateBudgetCommand(
                    null, budgetDetail.getLimit(), requestDTO.getActivityNO(),
                    requestDTO.getPrizeNO(), budgetDetail.getBudgetType(), budgetDetail.getDescription()
            );
            return command;
        }).collect(Collectors.toList());
    }
}
