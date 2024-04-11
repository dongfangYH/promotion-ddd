package com.ddd.activityservice.integration.acl;

import com.ddd.activityservice.domain.model.entity.PrizeInfo;
import com.ddd.activityservice.infrastructure.rpc.PrizeService;
import com.ddd.common.interfaces.rest.dto.PrizeInfoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AclPrizeService {

    private PrizeService prizeService;

    public AclPrizeService(PrizeService prizeService) {
        this.prizeService = prizeService;
    }

    public String savePrize(String activityNo, PrizeInfo prizeInfo){
        PrizeInfoDTO prizeInfoDTO = new PrizeInfoDTO();
        prizeInfoDTO.setActivityNO(activityNo);
        BeanUtils.copyProperties(prizeInfo, prizeInfoDTO);
        String prizeNO = prizeService.savePrize(prizeInfoDTO);
        prizeInfo.setPrizeNO(prizeNO);
        return prizeNO;
    }
}
