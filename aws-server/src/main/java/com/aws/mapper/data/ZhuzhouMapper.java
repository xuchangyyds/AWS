package com.aws.mapper.data;

import com.aws.po.DataZhuzhou;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Origami
 * @description
 * @create 2025-08-01 15:59
 **/
@Mapper
public interface ZhuzhouMapper {

    /**
     * 根据风机id查询主轴最新一条数据
     * @param windTurbineId 风机id
     * @return 主轴最新一条数据
     */
    DataZhuzhou queryNewestZhuzhouByTurbineId(String windTurbineId);
}
