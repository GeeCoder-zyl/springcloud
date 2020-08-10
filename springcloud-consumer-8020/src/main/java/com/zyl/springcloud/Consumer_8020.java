package com.zyl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @className: Consumer_8020
 * @description: 描述
 * @author: ZYL
 * @date: 2020/7/3 15:40
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//排除数据源
@EnableEurekaClient//链接注册中心
@EnableFeignClients//添加feign的支持
@EnableHystrix//开启断路器机制
public class Consumer_8020 {

    public static void main(String[] args) {

        SpringApplication.run(Consumer_8020.class, args);
    }
}
