package com.aws.mapper.data;

import com.aws.po.DataKongzhigui;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Origami
 * @description
 * @create 2025-08-07 10:50
 **/
@Mapper
public interface KongzhiguiMapper {

    /**
     * 根据风机id查询控制柜最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 控制柜最新一条数据
     */
    DataKongzhigui queryNewestKongzhiguiByTurbineId(String windTurbineId);
}
