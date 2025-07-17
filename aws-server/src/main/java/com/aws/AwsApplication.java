package com.aws;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin("*")
public class AwsApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(AwsApplication.class, args);
    }
}
