package com.springbootdemo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import  com.springbootdemo.utils.Log4jUtils;

@MapperScan("com.springbootdemo.*.mapper")
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		Log4jUtils.getLogger().info("Server Start............");
		SpringApplication.run(DemoApplication.class, args);
	}
}
