package com.aws.controller;


import com.aws.dto.WindPageQueryDTO;
import com.aws.po.TurbineAlert;
import com.aws.po.WindTurbine;
import com.aws.result.PageResult;
import com.aws.result.Result;
import com.aws.service.impl.WindService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aws/wind")
@Api(tags = "风机相关接口")
@Slf4j
public class WindController {

   @Autowired
   private WindService windService;
    /**
     * 根据区域 id 查询区域内的风机
     * @param  ，包含区域 ID、当前页码和每页数量
     * @return 分页后的风机列表
     */
    @ApiOperation("根据区域id查询区域内的风机")
    @GetMapping("/page")
    public Result<PageResult> list(WindPageQueryDTO windPageQueryDTO) {
        log.info("根据区域id查询区域内的风机：{}", windPageQueryDTO);
        PageResult pageResult = windService.pageQuery(windPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 根据区域风机id查询风机
     * @param  id
     * @return 区域信息
     */
    @ApiOperation("根据区域 风机id查询风机")
    @GetMapping("/{id}")
    public Result<WindTurbine> getById(@PathVariable Long id){
        log.info("根据区域风机id查询风机：{}",id);
        WindTurbine  windTurbine= windService.getById(id);
        return Result.success(windTurbine);
    }

    
    @ApiOperation("显示发生错误的风机原因")
    @GetMapping("/{id}/status")
    public Result<TurbineAlert> getStatusById(@PathVariable Long id){
        log.info("显示发生错误的风机原因：{}",id);
        TurbineAlert turbineAlert = windService.getStatusById(id);
        return Result.success(turbineAlert);
    }


    @ApiOperation("查询某个风机过去几个月的历史功率")
    @GetMapping("/{id}/history")
    public Result<Double> getHistoryById(@PathVariable Long id){
        log.info("查询某个风机过去几个月的历史功率：{}",id);
         Double history = windService.getHistoryById(id);
        return Result.success(history);
    }

    @ApiOperation("某风机运行小时数")
    @GetMapping("/{id}/runtime")
    public Result<Double> getRuntimeById(@PathVariable Long id){
        log.info("某风机运行小时数：{}",id);
        Double runtime = windService.getRuntimeById(id);
        return Result.success(runtime);
    }

    @ApiOperation("某风机控制柜温度")
    @GetMapping("/{id}/control_cabinet_temperature")
    public Result<Double> getTemperatureById(@PathVariable Long id){
        log.info("某风机控制柜温度：{}",id);
        Double temperature = windService.getccTemperatureById(id);
        return Result.success(temperature);
    }

}
