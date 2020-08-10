package com.zyl.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @className: Provider_8001
 * @description: 描述
 * @author: ZYL
 * @date: 2020/7/3 13:55
 */
@SpringBootApplication//声明为SpringBoot应用
@MapperScan("com.zyl.springcloud.mapper")//扫描数据库映射文件
@EnableEurekaClient//注册到Eureka注册中心
@EnableHystrix//开启断路器机制
public class Provider_8001 {

    public static void main(String[] args) {

        SpringApplication.run(Provider_8001.class, args);
    }
}
