package my.lab.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;


@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@EnableSwagger2
@ComponentScan

public class LabApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabApplication.class, args);
	}
	
	@Bean
	public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("my.lab.lab"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaData());
	}
	
	 private ApiInfo metaData() {
	        return new ApiInfoBuilder()
	                .title("Spring Boot REST API")
	                .description("\"Spring Boot REST API for Adding user\"")
	                .version("1.0.0")
	                .license("Apache License Version 2.0")
	                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
	                .contact(new Contact("Ayan Sayyed", "","sayyedayan92@gmail.com"))
	                .build();
	
	 }
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
	     registry
	         .addResourceHandler("swagger-ui.html")
	         .addResourceLocations("classpath:/META-INF/resources/");
	     registry
	         .addResourceHandler("/webjars/**")
	         .addResourceLocations("classpath:/META-INF/resources/webjars/");
	 }

}
		