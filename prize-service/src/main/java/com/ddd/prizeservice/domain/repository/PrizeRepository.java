package com.ddd.prizeservice.domain.repository;

import com.ddd.prizeservice.domain.model.aggregate.Prize;

public interface PrizeRepository {

    void save(Prize prize);
}
