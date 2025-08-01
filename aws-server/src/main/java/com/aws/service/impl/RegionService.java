package com.aws.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aws.enums.ResponseCode;
import com.aws.mapper.RegionEnvMapper;
import com.aws.po.RegionEnv;
import com.aws.util.JwtUtil;
import com.aws.mapper.RegionMapper;

import com.aws.po.Region;
import com.aws.service.IRegionService;
import com.aws.util.WeatherUtil;
import com.aws.vo.RegionEnvVO;
import com.aws.vo.RegionVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Origami
 * @description 区域Service
 * @create 2025-07-09 11:05
 **/
@Service
@Slf4j
public class RegionService implements IRegionService {

    @Autowired
    private RegionMapper regionMapper;

    @Autowired
    private RegionEnvMapper regionEnvMapper;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private WeatherUtil weatherUtil;


    /**
     * 获取所有区域信息
     *
     * @return 区域信息列表
     */
    @Override
    public List<RegionVO> getAllRegions() {
        List<Region> regions = regionMapper.selectAllRegions();

        List<RegionVO> regionVOS = new ArrayList<>();
        for (Region region : regions) {
            RegionVO regionVO = RegionVO.builder()
                    .regionName(region.getRegionName())
                    .id(region.getId())
                    .province(region.getProvince())
                    .city(region.getCity())
                    .latitude(region.getLatitude())
                    .longitude(region.getLongitude())
                    .build();

            regionVOS.add(regionVO);
        }
        return regionVOS;
    }

    /**
     * 获取区域详情
     *
     * @param id 区域ID
     * @return 区域详情
     */
    @Override
    public RegionEnvVO getRegionDetail(Long id) {
        // 根据ID查询区域信息
        Region region = regionMapper.getRegionDetailById(id);
        String regionCode = region.getRegionCode();

        // 生成JWT
        String jwt = null;
        try {
            jwt = jwtUtil.createJwt();
        } catch (Exception e) {
            log.error(ResponseCode.JWT_TOKEN_GENERATE_FAILED.getCode(), ResponseCode.JWT_TOKEN_GENERATE_FAILED.getInfo());
        }
        // 调用天气API获取实时天气
        JSONObject nowWeather = weatherUtil.getNowWeather(jwt, regionCode);
        log.info("nowWeather:{}", JSONObject.toJSONString(nowWeather));
        RegionEnvVO regionEnvVO = weatherUtil.apiToRegionEnvVO(id, nowWeather);

        // 保存到数据库
        RegionEnv regionEnv = RegionEnv.builder()
                .regionId(regionEnvVO.getRegionId())
                .recordTime(regionEnvVO.getRecordTime())
                .weatherDesc(regionEnvVO.getWeatherDesc())
                .temperature(regionEnvVO.getTemperature())
                .humidity(regionEnvVO.getHumidity())
                .pressure(regionEnvVO.getPressure())
                .windSpeed(regionEnvVO.getWindSpeed())
                .windDirection(regionEnvVO.getWindDirection())
                .waveHeight(regionEnvVO.getWaveHeight())
                .wavePeriod(regionEnvVO.getWavePeriod())
                .waterSpeed(regionEnvVO.getWaterSpeed())
                .waterTemp(regionEnvVO.getWaterTemp())
                .visibility(regionEnvVO.getVisibility())
                .uvIndex(regionEnvVO.getUvIndex())
                .build();
        regionEnvMapper.insertRegionEnv(regionEnvVO);

        return regionEnvVO;
    }


}
