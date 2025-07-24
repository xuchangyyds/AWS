package com.aws.po;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
* 风机基础信息表
* @TableName wind_turbine
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WindTurbine {

    /*** 风机主键ID*/
    private Long id;

    /*** 所属区域ID*/
    private Long regionId;

    /*** 所属风场ID*/
    private Long farmId;

    /*** 风机编号（唯一）*/
    private String turbineCode;

    /*** 风机名称*/
    private String turbineName;

    /*** 风机状态（运行、维护、故障等）*/
    private String status;

    /*** 风机纬度*/
    private BigDecimal latitude;

    /*** 风机经度风机经度*/
    private BigDecimal longitude;

    /*** 安装日期安装日期*/
    private Date installDate;

    /*** 创建时间 创建时间*/
    private Date createTime;
}
