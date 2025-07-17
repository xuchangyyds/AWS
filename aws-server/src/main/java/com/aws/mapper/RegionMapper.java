package com.aws.mapper;

import com.aws.po.Region;
import com.aws.vo.RegionEnvVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Origami
 * @description 区域Mapper
 * @create 2025-07-09 11:03
 **/
@Mapper
public interface RegionMapper {
    /**
     * 查询所有区域信息
     * @return List<RegionEntity>
     */
    List<Region> selectAllRegions();

    /**
     * 根据区域ID查询区域详情
     * @param id 区域ID
     * @return RegionEntity
     */
    Region getRegionDetailById(Long id);

}