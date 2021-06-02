package com.mindtree.inventorysystem.swaggerconfig;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Component
public class SwaggerConfiguration {
	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.mindtree.inventorysystem")).build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo("Inventory Management System API", "API for Inventory Management system", "1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Varshini", null, "varshinirayala23@gmail.com"),
				"API License", null, Collections.emptyList());
	}
}
