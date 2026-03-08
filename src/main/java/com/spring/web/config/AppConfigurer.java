package com.spring.web.config;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.spring.web.interceptor.LogInterceptor;

@Configuration
public class AppConfigurer implements WebMvcConfigurer{
	
	@Autowired
	private LogInterceptor logInterceptor;
	
@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(logInterceptor)
			.addPathPatterns("/**")
			.excludePathPatterns("/save", "/gree");
	}

}
