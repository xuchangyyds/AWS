package com.aws.service.impl;

import com.aws.mapper.RegionMapper;

import com.aws.po.Region;
import com.aws.service.IRegionService;
import com.aws.vo.RegionVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Origami
 * @description 区域Service
 * @create 2025-07-09 11:05
 **/
@Service
@Slf4j
public class RegionService implements IRegionService {

    @Autowired
    private RegionMapper regionMapper;


    /**
     * 获取所有区域信息
     * @return 区域信息列表
     */
    @Override
    public List<RegionVO> getAllRegions() {
        List<Region> regions = regionMapper.selectAllRegions();

        List<RegionVO> regionVOS = new ArrayList<>();
        for (Region region : regions) {
            RegionVO regionVO = new RegionVO();
            regionVO.setRegionName(region.getRegionName());
            regionVOS.add(regionVO);
        }
        return regionVOS;
    }
}
