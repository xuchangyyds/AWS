package com.aws.dto;

import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
public class WindPageQueryDTO {

    /**
     * 区域 ID
     */
    private Long regionId;

    /**
     * 当前页码
     */
    private Integer page;

    /**
     * 每页数量
     */
    private Integer pageSize;


}
