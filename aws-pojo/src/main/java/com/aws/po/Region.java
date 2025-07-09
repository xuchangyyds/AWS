package com.aws.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Origami
 * @description 区域实体类
 * @create 2025-07-09 11:01
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    private Long id;
    private String regionName;
    private String regionCode;
    private Double latitude;
    private Double longitude;
    private String remark;
    private LocalDateTime createTime;
}
