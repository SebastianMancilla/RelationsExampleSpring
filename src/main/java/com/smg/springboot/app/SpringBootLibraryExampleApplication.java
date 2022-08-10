package com.smg.springboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootLibraryExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLibraryExampleApplication.class, args);
	}
	
	//Creacion del Bean para implementar RestTemplate
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
