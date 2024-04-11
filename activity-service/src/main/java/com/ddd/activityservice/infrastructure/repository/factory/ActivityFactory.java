package com.ddd.activityservice.infrastructure.repository.factory;

import com.ddd.activityservice.domain.model.aggregate.Activity;
import com.ddd.activityservice.infrastructure.repository.po.ActivityPO;
import org.springframework.stereotype.Service;

@Service
public class ActivityFactory {

    public ActivityPO createActivityPO(Activity activity){
        ActivityPO activityPO = new ActivityPO();
        activityPO.setName(activity.getName());
        activityPO.setActivityNo(activity.getActivityNo().no());
        activityPO.setDescription(activity.getDescription());
        activityPO.setStartTime(activity.getStartTime());
        activityPO.setEndTime(activity.getEndTime());
        activityPO.setStatus(activity.getStatus());
        return activityPO;
    }
}
