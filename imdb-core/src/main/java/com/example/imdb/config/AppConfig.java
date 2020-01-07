package com.example.imdb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
	"com.example.imdb.service.impl"	
})
public class AppConfig {

}
