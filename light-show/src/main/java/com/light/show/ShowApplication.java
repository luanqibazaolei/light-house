package com.light.show;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
// 微服务注册
@EnableDiscoveryClient
@EnableSwagger2
@EnableDubbo
public class ShowApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShowApplication.class);
    }

}
