package com.aws.po;



import java.io.Serializable;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
* 风机10分钟监控数据表
* @TableName turbine_data
*/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TurbineData implements Serializable {

    /*** 主键ID*/
    private Long id;
    /*** 风机ID，关联风机基础信息*/
    private Long turbineId;
    /** 数据采集时间（每10分钟一条）*/
    private Date recordTime;
    /** 错误状态码或描述（异常时填写）*/
    private String errorCode;
    /*** 平均风速*/
    private Double avgWindSpeed;
    /*** 最大风速*/
    private Double maxWindSpeed;
    /*** 最小风速*/
    private Double minWindSpeed;
    /*** 平均转速*/
    private Double avgRotation;
    /*** 最大转速*/
    private Double maxRotation;
    /*** 最小转速*/
    private Double minRotation;
    /*** 平均有功功率*/
    private Double avgPower;
    /*** 最大有功功率*/
    private Double maxPower;
    /*** 最小有功功率*/
    private Double minPower;
    /*** 平均无功功率*/
    private Double avgReactivePower;
    /*** 最大无功功率*/
    private Double maxReactivePower;
    /*** 最小无功功率*/
    private Double minReactivePower;
    /*** 风能提供的可用功率*/
    private Double availablePFromWind;
    /*** 技术原因造成的功率损失*/
    private Double availablePTech;
    /*** 不可抗力因素造成的功率损失*/
    private Double availablePForceMajeure;
    /*** 外部原因造成的功率损失*/
    private Double availablePExternal;
    /*** 运行小时数（累计）*/
    private Double operatingHours;
    /*** 累计发电量（kWh）*/
    private Double productionKwh;
    /*** 累计发电分钟数*/
    private Integer productionMinutes;
    /*** 机舱方向（含电缆扭转）*/
    private Double nacellePosition;
    /*** A叶片角度*/
    private Double bladeAngleA;
    /*** 逆变器功率平均值*/
    private Double inverterAvg;
    /*** 逆变器功率标准差*/
    private Double inverterStdDev;
    /*** 机舱温度*/
    private Double nacelleTemp;
    /*** 外部环境温度*/
    private Double ambientTemp;
    /*** 控制柜温度*/
    private Double controlCabinetTemp;
    /*** 前轴承温度*/
    private Double frontBearingTemp;
    /*** 后轴承温度*/
    private Double rearBearingTemp;
    /*** 叶片A温度*/
    private Double bladeATemp;
    /*** 叶片B温度*/
    private Double bladeBTemp;
    /*** 叶片C温度*/
    private Double bladeCTemp;
    /*** 转子温度1*/
    private Double rotorTemp1;
    /*** 转子温度2*/
    private Double rotorTemp2;
    /*** 定子温度1*/
    private Double statorTemp1;
    /*** 定子温度2*/
    private Double statorTemp2;
    /*** 塔筒温度*/
    private Double towerTemp;
    /*** 偏航逆变柜温度*/
    private Double yawInverterTemp;
    /*** 整流柜温度*/
    private Double rectifierCabinetTemp;
    /*** 变压器温度*/
    private Double transformerTemp;
    /** 数据创建时间*/
    private Date createTime;
}
