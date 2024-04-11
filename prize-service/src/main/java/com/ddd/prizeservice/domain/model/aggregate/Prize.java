package com.ddd.prizeservice.domain.model.aggregate;

import com.ddd.prizeservice.domain.command.CreatePrizeCommand;
import com.ddd.prizeservice.domain.model.valueobject.PrizeNO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Prize {

    private String name;
    private PrizeNO prizeNO;
    private String description;
    private Integer value;
    private String activityNO;

    public Prize(CreatePrizeCommand command){
        this.name = command.getName();
        this.prizeNO = command.getPrizeNO();
        this.description = command.getDescription();
        this.value = command.getValue();
        this.activityNO = command.getActivityNO();
    }
}
