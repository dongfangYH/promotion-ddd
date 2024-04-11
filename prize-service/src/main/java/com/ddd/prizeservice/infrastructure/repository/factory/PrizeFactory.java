package com.ddd.prizeservice.infrastructure.repository.factory;

import com.ddd.prizeservice.domain.model.aggregate.Prize;
import com.ddd.prizeservice.infrastructure.repository.po.PrizePO;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PrizeFactory {

    public PrizePO createPrizePO(Prize prize){
        PrizePO prizePO = new PrizePO();
        prizePO.setName(prize.getName());
        prizePO.setDescription(prize.getDescription());
        prizePO.setActivityNo(prize.getActivityNO());
        prizePO.setValue(prize.getValue());
        prizePO.setPrizeNO(prize.getPrizeNO().no());
        prizePO.setCreateTime(new Date());
        return prizePO;
    }
}
