package com.aws.service;

import com.aws.dto.WindPageQueryDTO;
import com.aws.po.TurbineAlert;
import com.aws.po.WindTurbine;
import com.aws.result.PageResult;
import org.springframework.stereotype.Service;

public interface ITurbineService {

    /**
     * 根据区域id、风场id、风机编码查询id
     * @param regionId 区域Id
     * @param windFieldId 风场Id
     * @param windTurbineCode 风机编码
     * @return 风机Id
     */
    Long getIdByParams(Long regionId, Long windFieldId, String windTurbineCode);




    /**
     * 根据区域id分页查询
     * @param windPageQueryDTO
     * @return
     */
    PageResult pageQuery(WindPageQueryDTO windPageQueryDTO);


    /**
     * 根据风机id查询
     * @param id
     * @return
     */
    WindTurbine getById(Long id);


    /**
     * 根据id查询风机状态
     * @param id
     * @return
     */
    TurbineAlert getStatusById(Long id);


    /**
     * 根据id查询风机历史功率
     * @param id
     * @return
     */
    Double getHistoryById(Long id);

    Double getRuntimeById(Long id);



    Double getccTemperatureById(Long id);


}
