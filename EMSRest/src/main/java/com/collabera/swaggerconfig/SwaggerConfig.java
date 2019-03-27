/**
 * 
 */
package com.collabera.swaggerconfig;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author rutpatel
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	// Generate swagger docs using below URL
	// http://localhost:8080/v2/api-docs
	// Copy Paste JSON format to Swagger Editor
	@Bean
	public Docket emsApi() {

		Docket dock = new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.collabera")).paths(PathSelectors.ant("/*/*")).build();

		@SuppressWarnings("rawtypes")
		Collection<VendorExtension> extensions = new ArrayList<>();
		Contact contact = new Contact("Rut Patel", "https://www.linkedin.com/in/patel-rut", "rutpatel1996@gmail.com");
		ApiInfo apiInfo = new ApiInfo("Employee Management System RESTful APIs", "Employee Description", "0.0.1",
				"http://localhost:8080/termsofservice", contact, "License of EMS RESTful API", "https://www.github.com/darkerror96",
				extensions);
		dock.apiInfo(apiInfo);

		return dock;

//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.collabera")).build();

	}

}
