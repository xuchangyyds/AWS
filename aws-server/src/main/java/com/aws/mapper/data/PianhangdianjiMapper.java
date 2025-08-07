package com.aws.mapper.data;

import com.aws.po.DataPianhangdianji;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Origami
 * @description
 * @create 2025-08-07 10:45
 **/
@Mapper
public interface PianhangdianjiMapper {
    /**
     * 根据风机id查询偏航点击最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 偏航电机最新一条数据
     */
    DataPianhangdianji queryNewestPianhangdianjiByTurbineId(String windTurbineId);
}
