package com.ddd.activityservice.application.commandservice;

import com.ddd.activityservice.domain.command.CreateActivityCommand;
import com.ddd.activityservice.domain.model.aggregate.Activity;
import com.ddd.activityservice.domain.model.valueobject.ActivityNO;
import com.ddd.activityservice.domain.repository.ActivityRepository;
import com.ddd.activityservice.integration.acl.AclBudgetService;
import com.ddd.activityservice.integration.acl.AclPrizeService;
import com.ddd.activityservice.integration.event.ActivityEventPublisher;
import com.ddd.common.domain.event.ActivityCreatedEvent;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class ActivityCommandService {

    private ActivityRepository activityRepository;

    @Resource
    private ActivityEventPublisher eventPublisher;
    @Resource
    private AclPrizeService prizeService;
    @Resource
    private AclBudgetService budgetService;

    public ActivityCommandService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public ActivityNO handleActivityApply(CreateActivityCommand command){
        String activityNo = UUID.randomUUID().toString();
        command.setActivityNo(activityNo);
        Activity activity = new Activity(command);
        activityRepository.save(activity);
        ActivityCreatedEvent event = new ActivityCreatedEvent(
                activity.getActivityNo().no(),
                new Date()
        );
        eventPublisher.activityCreated(event);

        activity.getPrizes().forEach(prize -> {
            prizeService.savePrize(activityNo, prize);
            budgetService.saveBudgets(activityNo, prize.getPrizeNO(), prize.getBudgets());
        });

        return activity.getActivityNo();
    }
}
