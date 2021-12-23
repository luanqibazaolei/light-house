package com.light.show;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.light.show.mapper")
@ComponentScan("com.light")
public class ShowApplication {
    public static void main(String[] args) {

        SpringApplication.run(ShowApplication.class);
    }

}
