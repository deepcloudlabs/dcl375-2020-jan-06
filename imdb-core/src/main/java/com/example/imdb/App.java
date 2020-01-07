package com.example.imdb;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.imdb.config.AppDevConfig;
import com.example.imdb.config.AppTestConfig;
import com.example.imdb.service.MovieService;
import com.example.imdb.service.impl.BusinessService;

public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext
		   container = 
//		   new ClassPathXmlApplicationContext(
//				   "spring-min-config.xml");
		   //-Dspring.profiles.active=test
		new AnnotationConfigApplicationContext(
				AppDevConfig.class,
				AppTestConfig.class);   
		MovieService movieSrv = 
				container.getBean(MovieService.class);
		movieSrv.findAllMoviesByYearRangeAndGenre(
				"Drama", 1970, 1979)
		   .forEach(System.out::println);
		container.getBean(BusinessService.class)
		          .fun();
		container.close();
	}
}





