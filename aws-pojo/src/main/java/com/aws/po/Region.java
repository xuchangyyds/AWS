package com.aws.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Origami
 * @description 区域实体类
 * @create 2025-07-09 11:01
 **/
/**
 * 风电区域信息表
 * @TableName region
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Region implements Serializable {

    /**
     * 区域主键ID
     */
    private Long id;
    /**
     * 区域名称
     */
    private String regionName;
    /**
     * 区域编码（唯一标识）
     */
    private String regionCode;
    /**
     * 区域中心点纬度
     */
    private BigDecimal latitude;
    /**
     * 区域中心点经度
     */
    private BigDecimal longitude;
    /**
     * 备注信息
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date createTime;

}
