package com.aws.po;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WindFarm {

    /*** 主键ID，自增*/
    private Long id;

    /*** 风电场名称*/
    private String name;

    /*** 风电场类型（陆上/海上）*/
    private Object type;

    /*** 风电场中心点纬度*/
    private Double latitude;

    /*** 风电场中心点经度*/
    private Double longitude;


    /*** 所属区域ID*/
    private Long regionId;


    /*** 详细地址*/
    private String detailAddress;

}
