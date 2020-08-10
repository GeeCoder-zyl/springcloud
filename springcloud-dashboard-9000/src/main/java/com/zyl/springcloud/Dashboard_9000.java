package com.zyl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
@EnableHystrixDashboard	//启动仪表盘监控程序
@EnableEurekaClient//链接注册中心
public class Dashboard_9000 {
	
	public static void main(String[] args) {
		
		SpringApplication.run(Dashboard_9000.class, args);
	}
}
