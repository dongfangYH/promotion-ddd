package com.ddd.activityservice.infrastructure.repository.po;

import com.ddd.common.domain.enums.ActivityStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "activity")
@Setter
@Getter
public class ActivityPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(name = "activity_no")
    private String activityNo;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    private ActivityStatus status;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;
}
