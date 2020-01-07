package com.example.imdb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"dev","test"})
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {
	"com.example.imdb.aop"	
})
public class AopConfig {

}
