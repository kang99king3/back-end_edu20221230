package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Demotest1Application{

	//Spring boot에 내장된 서버를 실행시킨다
	public static void main(String[] args) {
		SpringApplication.run(Demotest1Application.class, args);
	}

}
