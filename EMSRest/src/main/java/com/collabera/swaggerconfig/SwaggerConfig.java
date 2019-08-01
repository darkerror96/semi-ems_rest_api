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

	// Generate swagger documents using below URL
	// http://localhost:8080/v2/api-docs
	// Copy Paste JSON format to Swagger Editor
	@Bean
	public Docket emsApi() {

		Docket dock = new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.collabera")).paths(PathSelectors.ant("/*/*")).build();
		dock.useDefaultResponseMessages(false);

		@SuppressWarnings("rawtypes")
		Collection<VendorExtension> extensions = new ArrayList<>();

		String name = "Rut Patel";
		String linkedIn = "https://www.linkedin.com/in/patel-rut";
		String eMail = "rutpatel1996@gmail.com";

		String title = "Employee Management System RESTful APIs";
		String description = "An Employee Management System totally based on REST API calls.\nAnd if you still use SOAP, better take a REST.";
		String version = "0.0.1";
		String license = "License of EMS RESTful API";
		String gitHub = "https://www.github.com/darkerror96";
		String termsOfService = "http://localhost:8080/termsofservice";

		Contact contact = new Contact(name, linkedIn, eMail);
		ApiInfo apiInfo = new ApiInfo(title, description, version, termsOfService, contact, license, gitHub,
				extensions);
		dock.apiInfo(apiInfo);

		return dock;

//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.collabera")).build();

	}

}
