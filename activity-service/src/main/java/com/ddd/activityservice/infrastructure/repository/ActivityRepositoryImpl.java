package com.ddd.activityservice.infrastructure.repository;

import com.ddd.activityservice.domain.model.aggregate.Activity;
import com.ddd.activityservice.domain.repository.ActivityRepository;
import com.ddd.activityservice.infrastructure.repository.factory.ActivityFactory;
import com.ddd.activityservice.infrastructure.repository.mapper.ActivityMapper;
import com.ddd.activityservice.infrastructure.repository.po.ActivityPO;
import org.springframework.stereotype.Service;

@Service
public class ActivityRepositoryImpl implements ActivityRepository {

    private ActivityMapper activityMapper;
    private ActivityFactory activityFactory;

    public ActivityRepositoryImpl(ActivityMapper activityMapper, ActivityFactory activityFactory) {
        this.activityMapper = activityMapper;
        this.activityFactory = activityFactory;
    }

    @Override
    public void save(Activity activity) {
        ActivityPO activityPO = activityFactory.createActivityPO(activity);
        activityMapper.save(activityPO);
    }
}
