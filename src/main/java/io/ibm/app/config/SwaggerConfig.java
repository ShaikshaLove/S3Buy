package io.ibm.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2

public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.basePackage("io.ibm.app.provider"))
		    	.paths(regex("/api.*"))
				.build()
				.apiInfo(apiInfo());
	}

	public ApiInfo apiInfo(){
		ApiInfo apiInfo = new ApiInfo(
				"S3Buy.in",
				"REST API Documentation for S3Buy.in",
				"1.0",
				"Terms of service",
				new Contact("Shaiksha", "https://www.s3buy.in", "s3buy@gmail.com"),
				"Apache License Version 2.0",
				"https://www.apache.org/licenses/LICENSE-2.0");
		return apiInfo;
	}
}