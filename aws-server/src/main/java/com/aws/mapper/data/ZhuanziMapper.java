package com.aws.mapper.data;

import com.aws.po.DataZhuanzi;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Origami
 * @description
 * @create 2025-08-07 10:26
 **/
@Mapper
public interface ZhuanziMapper {
    /**
     * 根据风机id查询转子最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 主轴最新一条数据
     */
    DataZhuanzi queryNewestZhuanziByTurbineId(String windTurbineId);
}
