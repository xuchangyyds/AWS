package com.aws.mapper;

import com.aws.vo.WindFarmVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface WindFarmMapper {

    /**
     * 根据区域 id 查询风场
     * @param regionId
     * @return
     */
    List<WindFarmVO> getByRegionId(Long regionId);
}
