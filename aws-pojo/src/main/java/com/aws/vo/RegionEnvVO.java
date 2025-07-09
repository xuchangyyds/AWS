package com.aws.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


/**
* 区域历史环境数据（天气、风速、水速等）
* @TableName region_env
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegionEnvVO implements Serializable{


    /** 主键ID*/
    private Long id;

    /** 区域ID*/
    private Long regionId;

    /** 采集时间（如每10分钟）*/
    private Date recordTime;

    /** 天气描述（晴、多云、雨等）*/
    private String weatherDesc;

    /** 气温（℃）*/
    private Double temperature;

    /** 湿度（%）*/
    private Double humidity;

    /** 气压（hPa）*/
    private Double pressure;

    /** 风速（m/s）*/
    private Double windSpeed;

    /** 风向（如：东南风）*/
    private String windDirection;

    /** 海浪高度（米）*/
    private Double waveHeight;

    /** 波浪周期（秒）*/
    private Double wavePeriod;

    /** 水流速度（m/s）*/
    private Double waterSpeed;

    /** 海水温度（℃）*/
    private Double waterTemp;

    /** 能见度（公里）*/
    private Double visibility;

    /** 紫外线指数*/
    private Double uvIndex;


}
