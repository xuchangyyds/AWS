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
 * @create 2025-08-07 10:53
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataFenglengzhuangzhiVO {

    /** 风机ID，关联wind_turbine表*/
    private Long turbineId;
    /** 冷却器类型*/
    private String coolerType;
    /** 风扇类型*/
    private String fanType;
    /** 风扇功率(千瓦)*/
    private BigDecimal fanPower;
    /** 风量(立方米/小时)*/
    private BigDecimal airFlow;
    /** 冷却效率(%)*/
    private BigDecimal coolingEfficiency;
    /** 工作温度(摄氏度)*/
    private BigDecimal workingTemperature;
    /** 装置重量(千克)*/
    private BigDecimal deviceWeight;
    /** 风扇转速(转/分钟)*/
    private BigDecimal fanSpeed;
    /** 风扇运行时间(小时)*/
    private BigDecimal operatingHours;
    /** 风扇故障状态(0无故障)*/
    private Integer faultStatus;
    /** 冷却器噪音级别(分贝)*/
    private BigDecimal noiseLevel;
    /** 记录时间*/
    private Date recordTime;
    /** 创建时间*/
    private Date createTime;
    /** 更新时间*/
    private Date updateTime;
}