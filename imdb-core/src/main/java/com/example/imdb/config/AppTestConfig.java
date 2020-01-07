package com.example.imdb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.example.imdb.service.impl.BusinessService;

@Configuration
@ComponentScan(basePackages = {
	"com.example.imdb.service.impl"	
})
@PropertySource("classpath:application-test.properties")
@Profile("test")
public class AppTestConfig {
	@Bean
	public BusinessService elma() {
		return new BusinessService();
	}
}





