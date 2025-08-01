package com.aws.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

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

    private String province;

    private String city;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private List<List<Point>> polygon;


    @Data
    public static class Point {
        private Double lng;
        private Double lat;
    }
}