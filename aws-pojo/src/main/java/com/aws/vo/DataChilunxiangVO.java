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
 * @create 2025-08-07 11:11
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataChilunxiangVO {

    /**风机ID，关联wind_turbine表*/
    private Long turbineId;
    /**齿轮箱类型*/
    private String gearboxType;
    /** 齿轮箱比*/
    private String gearRatio;
    /**齿轮箱输入转速(转/分钟)*/
    private BigDecimal inputSpeed;
    /**齿轮箱输出转速(转/分钟)*/
    private BigDecimal outputSpeed;
    /**齿轮箱效率(%)*/
    private BigDecimal efficiency;
    /**齿轮箱温度(摄氏度)*/
    private BigDecimal gearboxTemperature;
    /**齿轮箱重量(千克)*/
    private BigDecimal gearboxWeight;
    /** 齿轮材料*/
    private String gearMaterial;
    /**齿轮箱噪音级别(分贝)*/
    private BigDecimal noiseLevel;
    /**齿轮箱润滑方式*/
    private String lubricationMethod;
    /**齿轮磨损程度(毫米)*/
    private BigDecimal wearLevel;
    /** 记录时间*/
    private Date recordTime;
    /** 创建时间*/
    private Date createTime;
    /** 更新时间*/
    private Date updateTime;

}
