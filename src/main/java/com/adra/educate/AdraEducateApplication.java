package com.adra.educate;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdraEducateApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdraEducateApplication.class, args);
	}


	@Bean
	public OpenAPI springEmployeeOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("ADRA educate")
						.description("Esta es la Documentacion de la API de la ADRA educate.")
						.version("v0.0.1")
						.license(new License().name("MIT").url("https://opensource.org/licenses/MIT")));
	}

}
