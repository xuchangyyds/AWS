package com.aws.mapper;

import com.aws.vo.RegionEnvVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Origami
 * @description
 * @create 2025-07-17 13:52
 **/
@Mapper
public interface RegionEnvMapper {
    /**
     * 插入区域环境信息
     * @param regionEnvVO 区域环境信息VO
     */
    void insertRegionEnv(RegionEnvVO regionEnvVO);
}
