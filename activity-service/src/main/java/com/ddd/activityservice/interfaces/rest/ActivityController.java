package com.ddd.activityservice.interfaces.rest;

import com.ddd.activityservice.application.commandservice.ActivityCommandService;
import com.ddd.activityservice.application.queryservice.ActivityQueryService;
import com.ddd.activityservice.domain.command.CreateActivityCommand;
import com.ddd.activityservice.domain.model.valueobject.ActivityNO;
import com.ddd.activityservice.interfaces.rest.assembler.CreateActivityCommandDTOAssembler;
import com.ddd.common.interfaces.rest.dto.CreateActivityDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    private ActivityCommandService activityCommandService;
    private ActivityQueryService activityQueryService;

    public ActivityController(ActivityCommandService activityCommandService, ActivityQueryService activityQueryService) {
        this.activityCommandService = activityCommandService;
        this.activityQueryService = activityQueryService;
    }

    @PostMapping
    public ActivityNO createActivity(@RequestBody @Validated CreateActivityDTO createActivityDTO){
        CreateActivityCommand command = CreateActivityCommandDTOAssembler.toCommandFromDTO(createActivityDTO);
        return activityCommandService.handleActivityApply(command);
    }
}
