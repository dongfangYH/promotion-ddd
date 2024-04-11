package com.ddd.budgetservice.domain.repository;

import com.ddd.budgetservice.domain.model.aggregate.Budget;

public interface BudgetRepository {

    void save(Budget budget);
}
