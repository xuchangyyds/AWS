package com.aws.controller;


import com.aws.result.Result;
import com.aws.service.IWindFarmService;
import com.aws.vo.WindFarmVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author Origami
 * @description 区域Controller
 * @create 2025-07-24 12:30
 **/
@RestController
@RequestMapping("/api/v1/aws/farm")
@Api(tags = "风场相关接口")
@Slf4j
public class WindFarmController {

    @Resource
    private IWindFarmService windFarmService;
    @GetMapping("/{regionId}")
    @ApiOperation("根据区域id查询风场")
    public Result<List<WindFarmVO>> getByRegionId(@PathVariable Long regionId) {
        log.info("根据区域id查询风场");
        List<WindFarmVO> list = windFarmService.getByRegionId(regionId);
        return Result.success(list);
    }
}
