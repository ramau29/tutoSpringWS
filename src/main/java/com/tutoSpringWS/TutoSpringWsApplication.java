package com.tutoSpringWS;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TutoSpringWsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TutoSpringWsApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TutoSpringWsApplication.class);
	}

	@Bean
	public ModelMapper modelMapper() { return new ModelMapper(); }

}
