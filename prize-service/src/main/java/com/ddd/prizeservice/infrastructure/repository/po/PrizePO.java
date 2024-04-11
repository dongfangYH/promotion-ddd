package com.ddd.prizeservice.infrastructure.repository.po;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "prize")
@Setter
@Getter
public class PrizePO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(name = "prize_no")
    private String prizeNO;

    @Column(name = "activity_no")
    private String activityNo;
    @Column
    private String description;

    @Column
    private Integer value;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;
}
