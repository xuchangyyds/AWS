package com.aws.po;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
* 
* @TableName data_zhuzhouxiangqing
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataZhuzhouxiangqing{

    /** 主键ID*/
    private Long id;
    /** 风机ID，关联wind_turbine表*/
    private Long turbineId;
    /** 主轴直径(米)*/
    private BigDecimal shaftDiameter;
    /** 主轴长度(米)*/
    private BigDecimal shaftLength;
    /** 主轴材料*/
    private String shaftMaterial;
    /** 主轴重量(千克)*/
    private BigDecimal shaftWeight;
    /** 主轴转速(转/分钟)*/
    private BigDecimal rotationSpeed;
    /** 主轴承载能力(千牛)*/
    private BigDecimal loadCapacity;
    /** 主轴温度(摄氏度)*/
    private BigDecimal shaftTemperature;
    /** 主轴轴承类型*/
    private String bearingType;
    /** 主轴材料硬度(兆帕)*/
    private BigDecimal materialHardness;
    /** 主轴运行时间(小时)*/
    private BigDecimal operatingHours;
    /** 主轴磨损程度(毫米)*/
    private BigDecimal wearLevel;
    /** 记录时间*/
    private Date recordTime;
    /** 创建时间*/
    private Date createTime;
    /** 更新时间*/
    private Date updateTime;

}
