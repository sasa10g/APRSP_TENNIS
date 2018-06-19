package zuul;



import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Component
@Primary
@EnableAutoConfiguration
public class DocumentationController implements SwaggerResourcesProvider {
	
	//http://localhost:9100/swagger-ui.html
	
	//https://github.com/swagger-api/swagger-ui/issues/2839
	
	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<>();
		
		resources.add(swaggerResource("tennis-microservice-get", "/tennis-microservice-get/v2/api-docs", "2.4.0"));
		resources.add(swaggerResource("tennis-microservice-post", "/tennis-microservice-post/v2/api-docs", "2.4.0"));
		resources.add(swaggerResource("tennis-microservice-put", "/tennis-microservice-put/v2/api-docs", "2.4.0"));
		resources.add(swaggerResource("tennis-microservice-delete", "/tennis-microservice-delete/v2/api-docs", "2.4.0"));
		
		return resources;
	}
	
	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		
		return swaggerResource;
				
	}

}
