package com.ddd.activityservice.domain.model.aggregate;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.ListUtil;
import com.ddd.activityservice.domain.command.CreateActivityCommand;
import com.ddd.activityservice.domain.model.entity.PrizeInfo;
import com.ddd.activityservice.domain.model.valueobject.ActivityNO;
import com.ddd.common.domain.enums.ActivityStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class Activity {

    private String name;

    private String description;

    private ActivityNO activityNo;

    private ActivityStatus status;

    private Date startTime;

    private Date endTime;

    private List<PrizeInfo> prizes;


    public Activity(CreateActivityCommand command) {
        this.name = command.getActivityName();
        this.activityNo = new ActivityNO(command.getActivityNo());
        this.description = command.getDescription();
        this.startTime = command.getStartTime();
        this.endTime = command.getEndTime();
        this.prizes = new ArrayList<>();
        if (CollectionUtil.isNotEmpty(command.getPrizes())){
            for (PrizeInfo prizeInfo : command.getPrizes()){
                try{
                    prizes.add((PrizeInfo) prizeInfo.clone());
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
        }
        this.status = ActivityStatus.CREATED;
    }

}
