package com.aws.mapper.data;

import com.aws.po.DataFadianji;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Origami
 * @description
 * @create 2025-08-07 11:03
 **/
@Mapper
public interface FadianjiMapper {

    /**
     * 根据风机id查询发电机最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 发电机最新一条数据
     */
    DataFadianji queryNewestFadianjiByTurbineId(String windTurbineId);
}
