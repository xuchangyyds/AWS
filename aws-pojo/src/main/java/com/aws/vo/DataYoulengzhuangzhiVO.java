package com.aws.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Origami
 * @description
 * @create 2025-08-07 10:34
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataYoulengzhuangzhiVO {

    /** 风机ID，关联wind_turbine表*/
    private Long turbineId;
    /** 油冷却器类型*/
    private String coolerType;
    /** 油流量(升/分钟)*/
    private BigDecimal oilFlow;
    /** 油温(摄氏度)*/
    private BigDecimal oilTemperature;
    /** 冷却效率(%)*/
    private BigDecimal coolingEfficiency;
    /** 油冷装置重量(千克)*/
    private BigDecimal deviceWeight;
    /** 油类型*/
    private String oilType;
    /** 冷却介质温度(摄氏度)*/
    private BigDecimal coolantTemperature;
    /** 最大工作压力(巴)*/
    private BigDecimal maxPressure;
    /** 油冷却器运行时间(小时)*/
    private BigDecimal operatingHours;
    /** 油冷却器故障次数*/
    private Integer faultCount;
    /** 油流量波动(升/分钟)*/
    private BigDecimal flowVariation;
    /** 记录时间*/
    private Date recordTime;
    /** 创建时间*/
    private Date createTime;
    /** 更新时间*/
    private Date updateTime;
}