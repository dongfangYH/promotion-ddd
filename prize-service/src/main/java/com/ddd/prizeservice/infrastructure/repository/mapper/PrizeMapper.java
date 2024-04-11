package com.ddd.prizeservice.infrastructure.repository.mapper;

import com.ddd.prizeservice.infrastructure.repository.po.PrizePO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrizeMapper extends JpaRepository<PrizePO,Long> {
}
