package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		List<String>list=new ArrayList<>();
//		list.add("/board/**"); 

		registry.addInterceptor(new LoginInterceptor())
				.addPathPatterns("/**") //적용
				.excludePathPatterns("/home","/user/**","/logout","/css/**","/js/**");//제외
	}
}
