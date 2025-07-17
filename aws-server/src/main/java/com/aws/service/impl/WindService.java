package com.aws.service.impl;


import com.aws.mapper.WindMapper;
import com.aws.po.TurbineAlert;
import com.github.pagehelper.Page;
import com.aws.dto.WindPageQueryDTO;
import com.aws.po.WindTurbine;
import com.aws.result.PageResult;
import com.aws.service.IWindService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
public class WindService implements IWindService {


    @Autowired
    private WindMapper windMapper;

    @Override
    public PageResult pageQuery(WindPageQueryDTO windPageQueryDTO) {
        //select *from winturbine limit 0,10
        //开始分页查询
        PageHelper.startPage(windPageQueryDTO.getPage(),windPageQueryDTO.getPageSize());
        Page<WindTurbine> page =windMapper.pageQuery(windPageQueryDTO);
        long total = page.getTotal();
        List<WindTurbine> result = page.getResult();
        return new PageResult(total,result);
    }

    @Override
    public WindTurbine getById(Long id) {
        return windMapper.getById(id);
    }


    public TurbineAlert getStatusById(Long id) {
            return windMapper.getStatusById(id);
    }
}
