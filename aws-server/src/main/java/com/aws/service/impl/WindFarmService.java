package com.aws.service.impl;

import com.aws.mapper.WindFarmMapper;
import com.aws.po.WindFarm;
import com.aws.service.IWindFarmService;
import com.aws.service.IWindService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author Origami
 * @description 风场Service
 * @create 2025-07-09 11:05
 **/
@Service
@Slf4j
public class WindFarmService implements IWindFarmService {
    @Resource
    private WindFarmMapper windFarmMapper;
    @Override
    public List<WindFarm> getByRegionId(Long regionId) {

        return windFarmMapper.getByRegionId(regionId);
    }
}
