package com.aws.mapper;


import com.aws.po.WindFarm;
import com.aws.vo.WindFarmVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WindFarmMapper {

    /**
     * 根据区域 id 查询风场
     * @param regionId
     * @return
     */
    @Select("select * from wind_farm where region_id = #{regionId}")
    List<WindFarmVO> getByRegionId(Long regionId);
}
