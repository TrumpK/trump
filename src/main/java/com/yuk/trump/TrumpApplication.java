package com.yuk.trump;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan("com.yuk.trump.mapper")
@SpringBootApplication
public class TrumpApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TrumpApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TrumpApplication.class);
	}
}
