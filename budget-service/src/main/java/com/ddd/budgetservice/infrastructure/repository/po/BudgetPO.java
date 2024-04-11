package com.ddd.budgetservice.infrastructure.repository.po;

import com.ddd.common.domain.enums.BudgetType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "budget")
@Setter
@Getter
public class BudgetPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "budget_no")
    private String budgetNO;

    @Column(name = "budget_limit")
    private Integer limit;

    @Column(name = "budget_type")
    @Enumerated(EnumType.STRING)
    private BudgetType budgetType;

    @Column(name = "activity_no")
    private String activityNO;

    @Column(name = "prize_no")
    private String prizeNO;

    @Column
    private String description;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

}
