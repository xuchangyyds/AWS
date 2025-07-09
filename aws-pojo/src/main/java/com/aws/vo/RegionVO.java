package com.aws.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Origami
 * @description
 * @create 2025-07-09 12:07
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegionVO {

    private Long id;

    private String regionName;

}