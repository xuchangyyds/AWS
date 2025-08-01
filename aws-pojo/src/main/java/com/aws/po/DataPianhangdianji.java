package com.aws.po;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataPianhangdianji {

    /** 主键ID*/
    private Long id;
    /** 风机ID，关联wind_turbine表*/
    private Long turbineId;
    /** 电机类型*/
    private String motorType;
    /** 额定功率(千瓦)*/
    private BigDecimal ratedPower;
    /** 额定电压(伏特)*/
    private BigDecimal ratedVoltage;
    /** 额定转速(转/分钟)*/
    private BigDecimal ratedSpeed;
    /** 最大扭矩(千牛·米)*/
    private BigDecimal maxTorque;
    /** 电机重量(千克)*/
    private BigDecimal motorWeight;
    /** 控制类型*/
    private String controlType;
    /** 工作温度(摄氏度)*/
    private BigDecimal workingTemperature;
    /** 电机运行时间(小时)*/
    private BigDecimal operatingHours;
    /** 电机故障状态(0无故障)*/
    private Integer faultStatus;
    /** 电机启动次数*/
    private Integer startCount;
    /** 记录时间*/
    private Date recordTime;
    /** 创建时间*/
    private Date createTime;
    /** 更新时间*/
    private Date updateTime;

}
