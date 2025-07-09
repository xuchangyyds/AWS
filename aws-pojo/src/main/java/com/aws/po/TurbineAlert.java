package com.aws.po;

import java.io.Serializable;

import java.util.Date;

/**
* 风机异常报警记录表
* @TableName turbine_alert
*/
public class TurbineAlert implements Serializable {

    /*** 主键ID*/
    private Long id;
    /*** 风机ID*/
    private Long turbineId;
    /**报警时间*/
    private Date alertTime;
    /**错误码或异常类型*/
    private String errorCode;
    /*** 报警级别（如：警告、严重）*/
    private String alertLevel;
    /*** 报警描述*/
    private String description;
    /*** 是否已处理*/
    private Integer isProcessed;
    /*** 处理时间*/
    private Date processTime;
    /** 处理人员*/
    private String processUser;
}
