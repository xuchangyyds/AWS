package com.aws.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Origami
 * @description
 * @create 2025-07-09 15:40
 **/
@Configuration
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtConfig {
    private String privateKey;
    private String algorithm;
    private String kid;
    private String subject_id;
    private int expirationSeconds;
}