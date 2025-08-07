package com.aws.controller;


import com.aws.dto.WindPageQueryDTO;
import com.aws.po.TurbineAlert;
import com.aws.result.PageResult;
import com.aws.result.Result;
import com.aws.service.impl.TurbineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/aws/turbine")
@Api(tags = "风机相关接口")
@Slf4j
public class TurbineController {

    @Autowired
    private TurbineService turbineService;

    /**
     * 根据区域id、farmId、turbineCode查询风机
     *
     * @param regionId        区域id
     * @param windFieldId     farmId
     * @param windTurbineCode turbineCode
     * @return 风机id
     */
    @CrossOrigin(origins = "http://localhost:5173")
    @ApiOperation("根据区域 风机id查询风机")
    @GetMapping("/getIdByParams")
    public Result<Long> findTurbineByParams(
            @RequestParam("regionId") Long regionId,
            @RequestParam("windFieldId") Long windFieldId,
            @RequestParam("windTurbineCode") String windTurbineCode) {

        Long turbineId = turbineService.getIdByParams(regionId, windFieldId, windTurbineCode);
        log.info(String.valueOf(turbineId));
        return Result.success(turbineId);

    }




    /**
     * 根据区域 id 查询区域内的风机
     *
     * @param ，包含区域 ID、当前页码和每页数量
     * @return 分页后的风机列表
     */
    @ApiOperation("根据区域id查询区域内的风机")
    @GetMapping("/page")
    public Result<PageResult> list(WindPageQueryDTO windPageQueryDTO) {
        log.info("根据区域id查询区域内的风机：{}", windPageQueryDTO);
        PageResult pageResult = turbineService.pageQuery(windPageQueryDTO);
        return Result.success(pageResult);
    }

    @ApiOperation("显示发生错误的风机原因")
    @GetMapping("/{id}/status")
    public Result<TurbineAlert> getStatusById(@PathVariable Long id) {
        log.info("显示发生错误的风机原因：{}", id);
        TurbineAlert turbineAlert = turbineService.getStatusById(id);
        return Result.success(turbineAlert);
    }


    @ApiOperation("查询某个风机过去几个月的历史功率")
    @GetMapping("/{id}/history")
    public Result<Double> getHistoryById(@PathVariable Long id) {
        log.info("查询某个风机过去几个月的历史功率：{}", id);
        Double history = turbineService.getHistoryById(id);
        return Result.success(history);
    }

    @ApiOperation("某风机运行小时数")
    @GetMapping("/{id}/runtime")
    public Result<Double> getRuntimeById(@PathVariable Long id) {
        log.info("某风机运行小时数：{}", id);
        Double runtime = turbineService.getRuntimeById(id);
        return Result.success(runtime);
    }

    @ApiOperation("某风机控制柜温度")
    @GetMapping("/{id}/control_cabinet_temperature")
    public Result<Double> getTemperatureById(@PathVariable Long id) {
        log.info("某风机控制柜温度：{}", id);
        Double temperature = turbineService.getccTemperatureById(id);
        return Result.success(temperature);
    }

}
