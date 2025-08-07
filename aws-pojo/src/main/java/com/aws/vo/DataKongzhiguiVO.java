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
 * @create 2025-08-07 10:48
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataKongzhiguiVO {

    /** 风机ID，关联wind_turbine表*/
    private Long turbineId;
    /** 控制柜类型*/
    private String cabinetType;
    /** 额定电压(伏特)*/
    private BigDecimal ratedVoltage;
    /** 额定电流(安培)*/
    private BigDecimal ratedCurrent;
    /** 防护等级*/
    private String protectionLevel;
    /** 控制方式*/
    private String controlMethod;
    /** 柜体材料*/
    private String cabinetMaterial;
    /** 柜体重量(千克)*/
    private BigDecimal cabinetWeight;
    /** 工作温度(摄氏度)*/
    private BigDecimal workingTemperature;
    /** 柜内电流(安培)*/
    private BigDecimal internalCurrent;
    /** 柜内电压(伏特)*/
    private BigDecimal internalVoltage;
    /** 控制柜工作状态*/
    private String workingStatus;
    /** 记录时间*/
    private Date recordTime;
    /** 创建时间*/
    private Date createTime;
    /** 更新时间*/
    private Date updateTime;
}