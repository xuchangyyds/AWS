package com.aws.controller;

import com.aws.po.Region;
import com.aws.result.Result;
import com.aws.service.IRegionService;
import com.aws.service.impl.RegionService;
import com.aws.vo.RegionEnvVO;
import com.aws.vo.RegionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
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
    private IRegionService regionService;

    /**
     * 获取所有区域信息
     *
     * @return 区域信息列表
     */
    @GetMapping("/list")
    public Result<List<RegionVO>> getAllRegions() {
        List<RegionVO> regions = regionService.getAllRegions();
        return Result.success(regions);
    }

    /**
     * 获取区域详情
     *
     * @param id 区域ID
     * @return
     */
    @GetMapping("/{id}")
    public Result<RegionEnvVO> getRegionDetail(@PathVariable Long id) throws NoSuchAlgorithmException, InvalidKeySpecException, SignatureException, InvalidKeyException {
        RegionEnvVO regionEnvVO = regionService.getRegionDetail(id);
        return Result.success(regionEnvVO);
    }


}