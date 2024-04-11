package com.ddd.budgetservice.infrastructure.repository.po;

import com.ddd.common.domain.enums.BudgetRecordStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "budget_record")
@Setter
@Getter
public class BudgetRecordPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "budget_id")
    private Long budgetId;

    @Column(name = "activity_no")
    private String activityNO;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private BudgetRecordStatus budgetRecordStatus;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;
}
