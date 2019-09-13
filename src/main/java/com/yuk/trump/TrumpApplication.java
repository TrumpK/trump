package com.yuk.trump;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yuk.trump.mapper")
@SpringBootApplication
public class TrumpApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrumpApplication.class, args);
	}

}
