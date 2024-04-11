package com.ddd.activityservice.interfaces.rest.assembler;

import com.ddd.activityservice.domain.command.CreateActivityCommand;
import com.ddd.activityservice.domain.model.entity.BudgetInfo;
import com.ddd.activityservice.domain.model.entity.PrizeInfo;
import com.ddd.common.interfaces.rest.dto.BudgetInfoDTO;
import com.ddd.common.interfaces.rest.dto.CreateActivityDTO;
import com.ddd.common.interfaces.rest.dto.PrizeInfoDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CreateActivityCommandDTOAssembler {

    public static CreateActivityCommand toCommandFromDTO(CreateActivityDTO createActivityDTO){
        List<PrizeInfo> prizeInfoList = new ArrayList<>();
        Optional.ofNullable(createActivityDTO.getPrizes()).ifPresent(list -> list.forEach(
                prizeDto -> {
                    PrizeInfo prizeInfo = CreateActivityCommandDTOAssembler.toPrizeInfoFromDTO(prizeDto);
                    prizeInfoList.add(prizeInfo);
                    List<BudgetInfo> budgetInfoList = new ArrayList<>();
                    Optional.ofNullable(prizeDto.getBudgetInfoDTOList()).ifPresent(budgetList -> budgetList.forEach(
                            budgetDto -> {
                                BudgetInfo budgetInfo = CreateActivityCommandDTOAssembler.toBudgetInfoFromDTO(budgetDto);
                                budgetInfoList.add(budgetInfo);
                            }
                    ));
                    prizeInfo.setBudgets(budgetInfoList);
                }
        ));

        return new CreateActivityCommand(
          null,createActivityDTO.getActivityName(),createActivityDTO.getStartTime(),
          createActivityDTO.getEndTime(), createActivityDTO.getDescription(),prizeInfoList
        );
    }

    public static PrizeInfo toPrizeInfoFromDTO(PrizeInfoDTO prizeInfoDTO){
        PrizeInfo prizeInfo = new PrizeInfo();
        prizeInfo.setName(prizeInfoDTO.getName());
        prizeInfo.setDescription(prizeInfoDTO.getDescription());
        prizeInfo.setValue(prizeInfoDTO.getValue());
        return prizeInfo;
    }

    public static BudgetInfo toBudgetInfoFromDTO(BudgetInfoDTO budgetInfoDTO){
        BudgetInfo budgetInfo = new BudgetInfo();
        budgetInfo.setBudgetType(budgetInfoDTO.getBudgetType());
        budgetInfo.setDescription(budgetInfoDTO.getDescription());
        budgetInfo.setLimit(budgetInfoDTO.getLimit());
        return budgetInfo;
    }
}
