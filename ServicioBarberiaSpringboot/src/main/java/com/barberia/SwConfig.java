package com.barberia;
import java.util.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwConfig {
	
	
	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("com.barberia.controller"))
	      .paths(PathSelectors.any())         
	      .build()
	      .apiInfo(apiInfo());
	}
	 
	private ApiInfo apiInfo() {
	     return new ApiInfo(
	       "Titulo", 
	       "Descripción.", 
	       "Versiión 1.0", 
	       "Terminos del servicio", 
	       new Contact("barbersoft@gmail.com", "https://github.com/alonsoaz/ServicioBarberiaSpringboot", "barbersoft@gmail.com"), 
	       "License of API", "API license URL", Collections.emptyList());
	}
	
	
	
}