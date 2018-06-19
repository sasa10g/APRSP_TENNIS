package post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient //dodao
@SpringBootApplication
public class TennisMicroservicePostApplication {

	public static void main(String[] args) {
		SpringApplication.run(TennisMicroservicePostApplication.class, args);
	}
}
