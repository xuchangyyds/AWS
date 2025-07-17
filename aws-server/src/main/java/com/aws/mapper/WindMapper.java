package com.aws.mapper;

import com.aws.dto.WindPageQueryDTO;
import com.aws.po.TurbineAlert;
import com.aws.po.WindTurbine;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WindMapper {


    /**
     * 根据区域id分页查询
     *
     * @param windPageQueryDTO
     * @return
     */

    Page<WindTurbine> pageQuery(WindPageQueryDTO windPageQueryDTO);

    /**
     * 根据风机id查询
     *
     * @param id
     * @return
     */
    WindTurbine getById(Long id);

    /**
     * 根据id查询状态
     *
     * @param id
     * @return
     */
    @Select("select * from turbine_alert where turbine_id = #{id} order by id desc limit 1")
    TurbineAlert getStatusById(Long id);


    /**
     * 根据id查询历史功率
     *
     * @param id
     * @return
     */
    @Select("select avg_power from wind_turbine.turbine_data where id = #{id} order by id desc limit 1")
    Double getHistoryById(Long id);


    /**
     * 根据id查询运行小时数
     *
     * @param id
     * @return
     */
    @Select("select operating_hours from wind_turbine.turbine_data where id = #{id} order by id desc limit 1")
    Double getRuntimeById(Long id);

    /**
     * 根据id查询控制柜温度
     *
     * @param id
     * @return
     */
    @Select("select control_cabinet_temp from wind_turbine.turbine_data where id = #{id} order by id desc limit 1")
    Double getccTemperatureById(Long id);
}

