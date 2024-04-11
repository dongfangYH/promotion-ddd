package com.ddd.budgetservice.infrastructure.repository;

import com.ddd.budgetservice.domain.model.aggregate.Budget;
import com.ddd.budgetservice.domain.repository.BudgetRepository;
import com.ddd.budgetservice.infrastructure.repository.factory.BudgetFactory;
import com.ddd.budgetservice.infrastructure.repository.mapper.BudgetMapper;
import com.ddd.budgetservice.infrastructure.repository.po.BudgetPO;
import org.springframework.stereotype.Service;

@Service
public class BudgetRepositoryImpl implements BudgetRepository {

    private BudgetMapper budgetMapper;

    private BudgetFactory budgetFactory;

    public BudgetRepositoryImpl(BudgetMapper budgetMapper, BudgetFactory budgetFactory) {
        this.budgetMapper = budgetMapper;
        this.budgetFactory = budgetFactory;
    }

    @Override
    public void save(Budget budget) {
        BudgetPO budgetPO = budgetFactory.createPrizePO(budget);
        budgetMapper.save(budgetPO);
    }
}
