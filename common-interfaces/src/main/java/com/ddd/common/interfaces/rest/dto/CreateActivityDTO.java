package com.ddd.common.interfaces.rest.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateActivityDTO {

    @NotNull
    private String activityName;
    private Date startTime;
    private Date endTime;
    private String description;
    private List<PrizeInfoDTO> prizes;
}
