package com.aws.mapper;

import com.aws.dto.WindPageQueryDTO;
import com.aws.po.WindTurbine;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

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
}
