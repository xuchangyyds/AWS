package com.aws.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 风机信息视图对象，用于接口返回给前端展示
 */
@Data
public class WindTurbineVO {

    /** 风机主键 ID */
    private Long id;
    /** 所属区域 ID */
    private Long regionId;
    /** 风机编号（唯一） */
    private String turbineCode;
    /** 风机名称 */
    private String turbineName;
    /** 风机状态（运行、维护、故障等） */
    private String status;
    /** 风机纬度 */
    private BigDecimal latitude;
    /** 风机经度 */
    private BigDecimal longitude;
    /** 安装日期 */
    private Date installDate;
    /** 创建时间 */
    private Date createTime;
}
