package com.aws.mapper.data;

import com.aws.po.DataChilunxiang;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Origami
 * @description
 * @create 2025-08-07 11:12
 **/
@Mapper
public interface ChilunxiangMapper {

    /**
     * 根据风机id查询齿轮箱最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 齿轮箱最新一条数据
     */
    DataChilunxiang queryNewestChilunxiangByTurbineId(String windTurbineId);
}
