package com.aws.service;


import com.aws.po.WindFarm;
import com.aws.vo.WindFarmVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IWindFarmService {
    List<WindFarmVO> getByRegionId(Long regionId);
}
