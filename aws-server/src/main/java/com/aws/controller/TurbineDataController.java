package com.aws.controller;

import com.aws.result.Result;
import com.aws.service.ITurbineDataService;
import com.aws.vo.*;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Api(tags = "风机数据相关接口")
@RequestMapping("/api/v1/aws/turbineData")
public class TurbineDataController {

    @Autowired
    private ITurbineDataService turbineDataService;

    /**
     * 根据风机id查询变桨系统最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 变桨系统最新一条数据
     */
    @GetMapping("/bianjiangxitong/{windTurbineId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public Result<DataBianjiangxitongVO> queryNewestBianjiangxitongByTurbineId(@PathVariable String windTurbineId) {
        DataBianjiangxitongVO data = turbineDataService.queryNewestBianjiangxitongByTurbineId(windTurbineId);
        return Result.success(data);
    }

    /**
     * 根据风机id查询主轴最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 主轴最新一条数据
     */
    @GetMapping("/zhuzhou/{windTurbineId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public Result<DataZhuzhouVO> queryNewestZhuzhouByTurbineId(@PathVariable String windTurbineId) {
        DataZhuzhouVO data = turbineDataService.queryNewestZhuzhouByTurbineId(windTurbineId);
        return Result.success(data);
    }

    /**
     * 根据风机id查询转子最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 转子最新一条数据
     */
    @GetMapping("/zhuanzi/{windTurbineId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public Result<DataZhuanziVO> queryNewestZhuanziByTurbineId(@PathVariable String windTurbineId) {
        DataZhuanziVO data = turbineDataService.queryNewestZhuanziByTurbineId(windTurbineId);
        return Result.success(data);
    }

    /**
     * 根据风机id查询油冷最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 油冷装置最新一条数据
     */
    @GetMapping("/youlengzhuangzhi/{windTurbineId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public Result<DataYoulengzhuangzhiVO> queryNewestYoulengzhuangzhiByTurbineId(@PathVariable String windTurbineId) {
        DataYoulengzhuangzhiVO data = turbineDataService.queryNewestYoulengzhuangzhiByTurbineId(windTurbineId);
        return Result.success(data);
    }

    /**
     * 根据风机id查询偏航电机最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 偏航电机最新一条数据
     */
    @GetMapping("/pianhangdianji/{windTurbineId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public Result<DataPianhangdianjiVO> queryNewestPianhangdianjiByTurbineId(@PathVariable String windTurbineId) {
        DataPianhangdianjiVO data = turbineDataService.queryNewestPianhangdianjiByTurbineId(windTurbineId);
        return Result.success(data);
    }

    /**
     * 根据风机id查询控制柜最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 控制柜最新一条数据
     */
    @GetMapping("/kongzhigui/{windTurbineId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public Result<DataKongzhiguiVO> queryNewestKongzhiguiByTurbineId(@PathVariable String windTurbineId) {
        DataKongzhiguiVO data = turbineDataService.queryNewestKongzhiguiByTurbineId(windTurbineId);
        return Result.success(data);
    }

    /**
     * 根据风机id查询风冷装置最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 风冷装置最新一条数据
     */
    @GetMapping("/fenglengzhuangzhi/{windTurbineId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public Result<DataFenglengzhuangzhiVO> queryNewestFenglengzhuangzhiByTurbineId(@PathVariable String windTurbineId) {
        DataFenglengzhuangzhiVO data = turbineDataService.queryNewestFenglengzhuangzhiByTurbineId(windTurbineId);
        return Result.success(data);
    }

    /**
     * 根据风机id查询发电机最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 发电机最新一条数据
     */
    @GetMapping("/fadianji/{windTurbineId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public Result<DataFadianjiVO> queryNewestFadianjiByTurbineId(@PathVariable String windTurbineId) {
        DataFadianjiVO data = turbineDataService.queryNewestFadianjiByTurbineId(windTurbineId);
        return Result.success(data);
    }

    /**
     * 根据风机id查询齿轮箱最新一条数据
     *
     * @param windTurbineId 风机id
     * @return 齿轮箱最新一条数据
     */
    @GetMapping("/chilunxiang/{windTurbineId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public Result<DataChilunxiangVO> queryNewestChilunxiangByTurbineId(@PathVariable String windTurbineId) {
        DataChilunxiangVO data = turbineDataService.queryNewestChilunxiangByTurbineId(windTurbineId);
        return Result.success(data);
    }

}