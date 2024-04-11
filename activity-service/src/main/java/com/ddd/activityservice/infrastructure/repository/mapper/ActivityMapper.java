package com.ddd.activityservice.infrastructure.repository.mapper;

import com.ddd.activityservice.infrastructure.repository.po.ActivityPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityMapper extends JpaRepository<ActivityPO, Long> {
}
