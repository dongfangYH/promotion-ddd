package com.ddd.budgetservice.infrastructure.repository.mapper;

import com.ddd.budgetservice.infrastructure.repository.po.BudgetPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetMapper extends JpaRepository<BudgetPO, Long> {
}
