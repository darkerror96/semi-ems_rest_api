/**
 * 
 */
package com.collabera.swaggerconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
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

//		Predicate<RequestHandler> selector = RequestHandlerSelectors.basePackage("com.collabera");
//		Predicate<String> empPathSelector = PathSelectors.ant("/employee/*");
//		Predicate<String> manPathSelector = PathSelectors.ant("/manager/*");
//
//		Docket dock = new Docket(DocumentationType.SWAGGER_2).select().apis(selector).paths(empPathSelector).build();
//
//		@SuppressWarnings("rawtypes")
//		Collection<VendorExtension> extensions = new ArrayList<>();
//		Contact contact = new Contact("Contact Name", "URL", " Email");
//		ApiInfo apiInfo = new ApiInfo("Employee Rest API", "Employee Description", "0.0.1", "http://google.com",
//				contact, "License", "License URL", extensions);
//		dock.apiInfo(apiInfo);
//
//		return dock;

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.collabera")).build();

	}

}
