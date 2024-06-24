package com.inditex.inditex_technical_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableCaching
@EnableAspectJAutoProxy
public class InditexTechnicalTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(InditexTechnicalTestApplication.class, args);
	}

}
