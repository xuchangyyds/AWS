package com.aws.service.impl;


import com.aws.mapper.TurbineMapper;
import com.aws.po.TurbineAlert;
import com.github.pagehelper.Page;
import com.aws.dto.WindPageQueryDTO;
import com.aws.po.WindTurbine;
import com.aws.result.PageResult;
import com.aws.service.ITurbineService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
public class TurbineService implements ITurbineService {


    @Autowired
    private TurbineMapper turbineMapper;

    /**
     * 根据区域、风场、风机编码获取id
     * @param regionId 区域Id
     * @param windFieldId 风场Id
     * @param windTurbineCode 风机编码
     * @return id
     */
    @Override
    public Long getIdByParams(Long regionId, Long windFieldId, String windTurbineCode) {
        return turbineMapper.getIdByParams(regionId, windFieldId, windTurbineCode);
    }

    @Override
    public PageResult pageQuery(WindPageQueryDTO windPageQueryDTO) {
        //select *from winturbine limit 0,10
        //开始分页查询
        PageHelper.startPage(windPageQueryDTO.getPage(),windPageQueryDTO.getPageSize());
        Page<WindTurbine> page = turbineMapper.pageQuery(windPageQueryDTO);
        long total = page.getTotal();
        List<WindTurbine> result = page.getResult();
        return new PageResult(total,result);
    }

    @Override
    public WindTurbine getById(Long id) {
        return turbineMapper.getById(id);
    }


    public TurbineAlert getStatusById(Long id) {
            return turbineMapper.getStatusById(id);
    }

    @Override
    public Double getHistoryById(Long id) {
        return turbineMapper.getHistoryById(id);
    }

    @Override
    public Double getRuntimeById(Long id) {
        return  turbineMapper.getRuntimeById(id);

    }

    @Override
    public Double getccTemperatureById(Long id) {
        return turbineMapper.getccTemperatureById(id);
    }


}
