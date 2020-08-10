package com.zyl.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @className: Provider_8002
 * @description: 描述
 * @author: ZYL
 * @date: 2020/7/3 13:55
 */
@SpringBootApplication
@MapperScan("com.zyl.springcloud.mapper")
@EnableEurekaClient
@EnableHystrix//开启断路器机制
public class Provider_8002 {

    public static void main(String[] args) {

        SpringApplication.run(Provider_8002.class, args);
    }
}
