package com.aws.service;

import com.aws.po.Region;
import com.aws.vo.RegionVO;

import java.util.List;

/**
 * @author Origami
 * @description 区域Service
 * @create 2025-07-09 11:05
 **/
public interface IRegionService {

    /**
     * 获取所有区域信息
     * @return 所有区域信息
     */
    List<RegionVO> getAllRegions();
}
