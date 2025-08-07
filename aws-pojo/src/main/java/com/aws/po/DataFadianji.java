package com.aws.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataFadianji {

    /** 主键ID*/
    private Long id;
    /** 风机ID，关联wind_turbine表*/
    private Long turbineId;
    /** 发电机类型*/
    private String generatorType;
    /** 额定功率(千瓦)*/
    private BigDecimal ratedPower;
    /** 额定电压(伏特)*/
    private BigDecimal ratedVoltage;
    /** 额定频率(赫兹)*/
    private BigDecimal ratedFrequency;
    /** 效率(%)*/
    private BigDecimal efficiency;
    /** 发电机重量(千克)*/
    private BigDecimal weight;
    /** 转速(转/分钟)*/
    private BigDecimal rotationSpeed;
    /** 冷却方式*/
    private String coolingMethod;
    /** 发电机运行时间(小时)*/
    private BigDecimal operatingHours;
    /** 发电机故障状态(0无故障)*/
    private Integer faultStatus;
    /** 发电机启动次数*/
    private Integer startCount;
    /** 记录时间*/
    private Date recordTime;
    /** 创建时间*/
    private Date createTime;
    /** 更新时间*/
    private Date updateTime;
}
