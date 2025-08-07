package com.aws.mapper.data;

import com.aws.po.DataFenglengzhuangzhi;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Origami
 * @description
 * @create 2025-08-07 10:55
 **/
@Mapper
public interface FenglengzhuangzhiMapper {

    /**
     * 根据风机id查询风冷装置最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 风冷装置最新一条数据
     */
    DataFenglengzhuangzhi queryNewestFenglengzhuangzhiByTurbineId(String windTurbineId);
}
