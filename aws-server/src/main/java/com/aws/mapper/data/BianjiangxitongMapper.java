package com.aws.mapper.data;

import com.aws.po.DataBianjiangxitong;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Origami
 * @description
 * @create 2025-08-01 15:47
 **/
@Mapper
public interface BianjiangxitongMapper {

    /**
     * 根据风机id查询变桨系统最新一条数据
     * @param windTurbineId 风机id
     * @return 变桨系统最新一条数据
     */
    DataBianjiangxitong queryNewestBianjiangxitongByTurbineId(String windTurbineId);
}
