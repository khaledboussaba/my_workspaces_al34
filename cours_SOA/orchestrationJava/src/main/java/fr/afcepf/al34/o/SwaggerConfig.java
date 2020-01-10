package fr.afcepf.al34.o;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@Profile("swagger")
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() { 
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(/*RequestHandlerSelectors.any()*/RequestHandlerSelectors.basePackage("fr.afcepf.al34.ws.rest"))              
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());                                          
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("My Spring-Mvc REST APIs").version("1.0.0").build();
	}


}