package com.ddd.budgetservice.interfaces.rest;

import com.ddd.budgetservice.application.commandservice.BudgetCommandService;
import com.ddd.budgetservice.application.queryservice.BudgetQueryService;
import com.ddd.budgetservice.domain.command.CreateBudgetCommand;
import com.ddd.budgetservice.domain.model.valueobject.BudgetNO;
import com.ddd.budgetservice.interfaces.rest.assembler.CreateBudgetCommandDTOAssembler;
import com.ddd.common.interfaces.rest.dto.AddBudgetsRequestDTO;
import com.ddd.common.interfaces.rest.dto.BudgetInfoDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class BudgetController {

    private BudgetCommandService budgetCommandService;
    private BudgetQueryService budgetQueryService;

    public BudgetController(BudgetCommandService budgetCommandService, BudgetQueryService budgetQueryService) {
        this.budgetCommandService = budgetCommandService;
        this.budgetQueryService = budgetQueryService;
    }

    @PostMapping("/budget")
    public BudgetNO addBudget(@RequestBody @Validated BudgetInfoDTO budgetInfoDTO){
        CreateBudgetCommand command = CreateBudgetCommandDTOAssembler.toCommandFromDTO(budgetInfoDTO);
        return budgetCommandService.addBudget(command);
    }

    @PostMapping("/budgets")
    public List<BudgetNO> addBudgets(@RequestBody @Validated AddBudgetsRequestDTO requestDTO){
        List<CreateBudgetCommand> commandList = CreateBudgetCommandDTOAssembler.toCommandFromDTO(requestDTO);
        return budgetCommandService.addBudgets(commandList);
    }
}
