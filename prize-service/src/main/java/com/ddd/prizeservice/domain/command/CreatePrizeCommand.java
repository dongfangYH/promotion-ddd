package com.ddd.prizeservice.domain.command;

import com.ddd.prizeservice.domain.model.valueobject.PrizeNO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreatePrizeCommand {

    private String activityNO;
    private String name;
    private PrizeNO prizeNO;
    private String description;
    private Integer value;
}
