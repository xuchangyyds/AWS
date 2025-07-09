package com.aws.controller;

import com.aws.po.Region;
import com.aws.result.Result;
import com.aws.service.impl.RegionService;
import com.aws.vo.RegionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Origami
 * @description 区域Controller
 * @create 2025-07-09 11:07
 **/
@RestController
@RequestMapping("/api/v1/aws/region")
public class RegionController {

    @Autowired
    private RegionService regionService;


    /**
     * 获取所有区域信息
     * @return 区域信息列表
     */
    @GetMapping("/list")
    public Result<List<RegionVO>> getAllRegions() {
        List<RegionVO> regions = regionService.getAllRegions();

        return Result.success(regions);
    }


}