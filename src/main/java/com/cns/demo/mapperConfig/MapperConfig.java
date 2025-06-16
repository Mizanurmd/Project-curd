package com.cns.demo.mapperConfig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;

@Configuration
public class MapperConfig {
	 @Bean
	    public OpenAPI baseOpenAPI() {
	        return new OpenAPI().info(new Info().title("Demo API").version("1.0.0").description("Demo project API"));
	    }

	    @Bean
	    public GroupedOpenApi publicApi() {
	        return GroupedOpenApi.builder()
	                .group("/api/v1/projects")
	                .packagesToScan("com.cns.demo.contorller")
	                .build();
	    }

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
