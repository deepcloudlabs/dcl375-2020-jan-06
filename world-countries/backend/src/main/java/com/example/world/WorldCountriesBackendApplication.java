package com.example.world;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 
 * @author Binnur Kurt (binnur.kurt@gmail.com)
 *
 */
@SpringBootApplication
public class WorldCountriesBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorldCountriesBackendApplication.class, args);
	}
}
