package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AjaxserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(AjaxserverApplication.class, args);
	}

//	@Bean
//	public FilterRegistrationBean registerFilter() {
//		FilterRegistrationBean bean = new FilterRegistrationBean();
//		bean.addUrlPatterns("/*");
//		bean.setFilter(new CrosFilter());
//		return bean;
//	}

}
