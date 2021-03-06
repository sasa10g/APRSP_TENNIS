package get;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class Swagger {
	@Bean
	public Docket productApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("get"))
				.build()
				.apiInfo(metaInfo());
	}
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo("Tennis Club | (MicroserviceGET) | Backend APRSP Swagger", 
				"Agilni postupci u razvoju softverskih proizvoda",
				"1.0",
				"",
				new Contact("Sasa Gvozdenovic",
							"https://github.com/sasa10g",
							"sasagovzdenovic@hotmail.com"),
				
				"",
				"");
		
		return apiInfo;
	}
	

}
