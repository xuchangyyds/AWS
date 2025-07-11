package com.aws.service;

import com.aws.dto.WindPageQueryDTO;
import com.aws.po.WindTurbine;
import com.aws.result.PageResult;
import org.springframework.stereotype.Service;

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
}
