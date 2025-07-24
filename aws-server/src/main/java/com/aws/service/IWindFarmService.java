package com.aws.service;


import com.aws.po.WindFarm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IWindFarmService {
    List<WindFarm> getByRegionId(Long regionId);
}
