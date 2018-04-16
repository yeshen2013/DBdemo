package com.lyyexample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lyyexample.mapper.*Mapper")
public class DBdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DBdemoApplication.class, args);
	}
}
