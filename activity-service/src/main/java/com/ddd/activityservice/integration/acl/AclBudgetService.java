package com.ddd.activityservice.integration.acl;

import com.ddd.activityservice.domain.model.entity.BudgetInfo;
import com.ddd.activityservice.infrastructure.rpc.BudgetService;
import com.ddd.common.interfaces.rest.dto.AddBudgetsRequestDTO;
import com.ddd.common.interfaces.rest.dto.BudgetDetailDTO;
import com.ddd.common.interfaces.rest.dto.BudgetInfoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AclBudgetService {

    private BudgetService budgetService;

    public AclBudgetService(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    public void saveBudgets(String activityNo, String prizeNo, List<BudgetInfo> budgets){
        List<BudgetDetailDTO> budgetInfoDTOList = budgets.stream().map(
                budgetInfo -> {
                    BudgetDetailDTO budgetDetailDTO = new BudgetDetailDTO();
                    budgetDetailDTO.setDescription(budgetInfo.getDescription());
                    budgetDetailDTO.setBudgetType(budgetInfo.getBudgetType());
                    budgetDetailDTO.setLimit(budgetInfo.getLimit());
                    return budgetDetailDTO;
                }
        ).collect(Collectors.toList());
        AddBudgetsRequestDTO requestDTO = new AddBudgetsRequestDTO();
        requestDTO.setActivityNO(activityNo);
        requestDTO.setPrizeNO(prizeNo);
        requestDTO.setBudgetDetailDTOList(budgetInfoDTOList);
        budgetService.saveBudgets(requestDTO);
    }
}
