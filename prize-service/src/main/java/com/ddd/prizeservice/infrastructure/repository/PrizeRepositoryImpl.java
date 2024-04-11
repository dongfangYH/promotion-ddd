package com.ddd.prizeservice.infrastructure.repository;

import com.ddd.prizeservice.domain.model.aggregate.Prize;
import com.ddd.prizeservice.domain.repository.PrizeRepository;
import com.ddd.prizeservice.infrastructure.repository.factory.PrizeFactory;
import com.ddd.prizeservice.infrastructure.repository.mapper.PrizeMapper;
import com.ddd.prizeservice.infrastructure.repository.po.PrizePO;
import org.springframework.stereotype.Service;

@Service
public class PrizeRepositoryImpl implements PrizeRepository {

    private PrizeMapper prizeMapper;
    private PrizeFactory prizeFactory;

    public PrizeRepositoryImpl(PrizeMapper prizeMapper, PrizeFactory prizeFactory) {
        this.prizeMapper = prizeMapper;
        this.prizeFactory = prizeFactory;
    }

    @Override
    public void save(Prize prize) {
        PrizePO prizePO = prizeFactory.createPrizePO(prize);
        prizeMapper.save(prizePO);
    }
}
