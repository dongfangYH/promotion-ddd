package com.ddd.activityservice.domain.command;

import com.ddd.activityservice.domain.model.entity.PrizeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CreateActivityCommand {

    private String activityNo;
    private String activityName;
    private Date startTime;
    private Date endTime;
    private String description;
    private List<PrizeInfo> prizes;

}
