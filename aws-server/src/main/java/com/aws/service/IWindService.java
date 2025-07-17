package com.aws.service;

import com.aws.dto.WindPageQueryDTO;
import com.aws.po.TurbineAlert;
import com.aws.po.WindTurbine;
import com.aws.result.PageResult;
import com.aws.result.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IWindService {
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
