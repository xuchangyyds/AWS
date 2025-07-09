package com.aws.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Origami
 * @description
 * @create 2025-07-09 15:43
 **/
@Configuration
@ConfigurationProperties(prefix = "weather")
@Data
public class WeatherConfig {

    private String url;
}
