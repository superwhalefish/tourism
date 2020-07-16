package com.ly.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.ly.spring.dao")
@EnableAsync
public class LyTourismApplication {

	public static void main(String[] args) {
		SpringApplication.run(LyTourismApplication.class, args);
	}

}
