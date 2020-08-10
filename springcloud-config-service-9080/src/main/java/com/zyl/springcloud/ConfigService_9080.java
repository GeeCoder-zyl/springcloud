package com.zyl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})//排除数据源启动,否则会报错
@EnableConfigServer//开启配置中心设置
public class ConfigService_9080 {
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigService_9080.class, args);
	}
}
