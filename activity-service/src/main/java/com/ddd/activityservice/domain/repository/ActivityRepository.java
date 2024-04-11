package com.ddd.activityservice.domain.repository;

import com.ddd.activityservice.domain.model.aggregate.Activity;

public interface ActivityRepository {

    void save(Activity activity);
}
