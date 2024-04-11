package com.ddd.activityservice.infrastructure.rpc;

import com.ddd.common.interfaces.rest.dto.PrizeInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "prize-service")
public interface PrizeService {

    @PostMapping("/prize")
    String savePrize(@RequestBody @Validated PrizeInfoDTO prizeInfoDTO);
}
