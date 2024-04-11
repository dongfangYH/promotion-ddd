package com.ddd.prizeservice.interfaces.rest.assembler;

import com.ddd.common.interfaces.rest.dto.PrizeInfoDTO;
import com.ddd.prizeservice.domain.command.CreatePrizeCommand;

public class CreatePrizeCommandDTOAssembler {

    public static CreatePrizeCommand toCommandFromDTO(PrizeInfoDTO prizeInfoDTO){
        return new CreatePrizeCommand(
                prizeInfoDTO.getActivityNO(), prizeInfoDTO.getName(),
                null,prizeInfoDTO.getDescription(),prizeInfoDTO.getValue()
        );

    }
}
