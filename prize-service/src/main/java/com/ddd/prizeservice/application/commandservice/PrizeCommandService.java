package com.ddd.prizeservice.application.commandservice;

import com.ddd.common.domain.event.PrizeCreatedEvent;
import com.ddd.prizeservice.domain.command.CreatePrizeCommand;

import com.ddd.prizeservice.domain.model.aggregate.Prize;
import com.ddd.prizeservice.domain.model.valueobject.PrizeNO;
import com.ddd.prizeservice.domain.repository.PrizeRepository;
import com.ddd.prizeservice.integration.event.PrizeEventPublisher;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class PrizeCommandService {

    @Resource
    private PrizeEventPublisher prizeEventPublisher;

    private PrizeRepository prizeRepository;

    public PrizeCommandService(PrizeRepository prizeRepository) {
        this.prizeRepository = prizeRepository;
    }

    public PrizeNO addPrize(CreatePrizeCommand command){
        PrizeNO prizeNO = new PrizeNO(UUID.randomUUID().toString());
        command.setPrizeNO(prizeNO);

        Prize prize = new Prize(command);
        prizeRepository.save(prize);

        PrizeCreatedEvent event = new PrizeCreatedEvent(prizeNO.no(), new Date());
        prizeEventPublisher.prizeCreated(event);
        return prizeNO;
    }
}
