package com.aws.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ResponseCode {

    SUCCESS("0000", "成功"),
    UN_ERROR("0001", "未知失败"),
    ILLEGAL_PARAMETER("0002", "非法参数"),
    JWT_TOKEN_GENERATE_FAILED("0003", "JWT生成失败"),
    JWT_TOKEN_VERIFY_FAILED("0004", "JWT验证失败"),
    ;


    private String code;
    private String info;

}
