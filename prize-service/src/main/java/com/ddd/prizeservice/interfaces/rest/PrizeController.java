package com.ddd.prizeservice.interfaces.rest;

import com.ddd.common.interfaces.rest.dto.PrizeInfoDTO;
import com.ddd.prizeservice.application.commandservice.PrizeCommandService;
import com.ddd.prizeservice.application.queryservice.PrizeQueryService;
import com.ddd.prizeservice.domain.command.CreatePrizeCommand;
import com.ddd.prizeservice.domain.model.valueobject.PrizeNO;
import com.ddd.prizeservice.interfaces.rest.assembler.CreatePrizeCommandDTOAssembler;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PrizeController {

    private PrizeCommandService prizeCommandService;
    private PrizeQueryService prizeQueryService;

    public PrizeController(PrizeCommandService prizeCommandService, PrizeQueryService prizeQueryService) {
        this.prizeCommandService = prizeCommandService;
        this.prizeQueryService = prizeQueryService;
    }


    @PostMapping("/prize")
    public PrizeNO addPrize(@RequestBody @Validated PrizeInfoDTO prizeInfoDTO){
        CreatePrizeCommand command = CreatePrizeCommandDTOAssembler.toCommandFromDTO(prizeInfoDTO);
        return prizeCommandService.addPrize(command);
    }
}
