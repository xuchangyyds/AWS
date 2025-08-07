package com.aws.po;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataZhuanzi {

    /** 主键ID*/
    private Long id;
    /** 风机ID，关联wind_turbine表*/
    private Long turbineId;
    /** 转子直径*/
    private String rotorDiameter;
    /** 转子重量*/
    private String rotorWeight;
    /** 转子材料*/
    private String rotorMaterial;
    /** 转速*/
    private String rotationSpeed;
    /** 最大载荷*/
    private String maxLoad;
    /** 转子倾斜角度*/
    private String tiltAngle;
    /** 转子寿命*/
    private String lifeSpan;
    /** 转子气动效率*/
    private String aerodynamicEfficiency;
    /** 转子速度*/
    private String rotorSpeed;
    /** 转子材料强度*/
    private String materialStrength;
    /** 转子振动频率*/
    private String vibrationFrequency;
    /** 记录时间*/
    private Date recordTime;
    /** 创建时间*/
    private Date createTime;
    /** 更新时间*/
    private Date updateTime;
}
