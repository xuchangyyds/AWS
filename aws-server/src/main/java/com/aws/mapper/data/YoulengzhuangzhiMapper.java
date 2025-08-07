package com.aws.mapper.data;

import com.aws.po.DataYoulengzhuangzhi;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Origami
 * @description
 * @create 2025-08-07 10:39
 **/
@Mapper
public interface YoulengzhuangzhiMapper {

    /**
     * 根据风机id查询油冷最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 油冷装置最新一条数据
     */
    DataYoulengzhuangzhi queryNewestYoulengzhuangzhiByTurbineId(String windTurbineId);

}
