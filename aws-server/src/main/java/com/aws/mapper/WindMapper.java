package com.aws.mapper;

import com.aws.dto.WindPageQueryDTO;
import com.aws.po.TurbineAlert;
import com.aws.po.WindTurbine;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface WindMapper {


    /**
     * 根据区域id分页查询
     * @param windPageQueryDTO
     * @return
     */

    Page<WindTurbine> pageQuery(WindPageQueryDTO windPageQueryDTO);
    /**
     * 根据风机id查询
     * @param id
     * @return
     */
    WindTurbine getById(Long id);

    /**
     * 根据id查询状态
     * @param id
     * @return
     */
    @Select("select * from turbine_alert where turbine_id = #{id} order by id desc limit 1")
    TurbineAlert getStatusById(Long id);

}
