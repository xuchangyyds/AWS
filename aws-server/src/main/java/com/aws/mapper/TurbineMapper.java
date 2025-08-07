package com.aws.mapper;

import com.aws.dto.WindPageQueryDTO;
import com.aws.po.TurbineAlert;
import com.aws.po.WindTurbine;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TurbineMapper {


    /**
     * 根据区域、风场、风机编码获取id
     * @param regionId 区域Id
     * @param windFieldId 风场Id
     * @param windTurbineCode 风机编码
     * @return id
     */
    Long getIdByParams(Long regionId, Long windFieldId, String windTurbineCode);



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

