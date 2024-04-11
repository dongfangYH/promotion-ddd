package com.ddd.activityservice.infrastructure.rpc;

import com.ddd.common.interfaces.rest.dto.AddBudgetsRequestDTO;
import com.ddd.common.interfaces.rest.dto.BudgetInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "budget-service")
public interface BudgetService {

    @PostMapping("/budgets")
    void saveBudgets(@RequestBody AddBudgetsRequestDTO requestDTO);
}
