package com.aws.service;

import com.aws.vo.WindFarmVO;

import java.util.List;

public interface IWindFarmService {
    List<WindFarmVO> getByRegionId(Long regionId);
}
