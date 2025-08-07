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
 * @create 2025-08-07 11:16
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataBianjiangxitongVO {

    /** 风机ID，关联wind_turbine表*/
    private Long turbineId;
    /** 变桨角度(度)*/
    private BigDecimal pitchAngle;
    /** 变桨速度(度/秒)*/
    private BigDecimal pitchSpeed;
    /** 变桨系统温度(摄氏度)*/
    private BigDecimal systemTemperature;
    /** 电机负载(千瓦)*/
    private BigDecimal motorLoad;
    /** 变桨位置传感器反馈(米)*/
    private BigDecimal positionFeedback;
    /** 故障状态(0无故障)*/
    private Integer faultStatus;
    /** 电源电压(伏特)*/
    private BigDecimal powerVoltage;
    /** 桨叶压力(帕斯卡)*/
    private BigDecimal bladePressure;
    /** 变桨角度变化(度)*/
    private BigDecimal angleChange;
    /** 变桨响应时间(秒)*/
    private BigDecimal responseTime;
    /** 电流(安培)*/
    private BigDecimal current;
    /** 记录时间*/
    private Date recordTime;
    /** 创建时间*/
    private Date createTime;
    /** 更新时间*/
    private Date updateTime;
}