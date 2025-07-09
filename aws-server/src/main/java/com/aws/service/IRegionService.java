package com.aws.service;

import com.aws.po.Region;
import com.aws.vo.RegionEnvVO;
import com.aws.vo.RegionVO;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

/**
 * @author Origami
 * @description 区域Service
 * @create 2025-07-09 11:05
 **/
public interface IRegionService {

    /**
     * 获取所有区域信息
     * @return 所有区域信息
     */
    List<RegionVO> getAllRegions();

    /**
     * 根据ID查询区域天气详情
     * @param id 区域ID
     * @return 区域天气详情
     */
    RegionEnvVO getRegionDetail(Long id) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException;
}
