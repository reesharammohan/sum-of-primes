package com.sample.prime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

	@Bean
    public OpenAPI sumOfPrimesOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Sum of Prime numbers")
                        .description("Sum of prime number upto 10 million")
                        .version("v1.0.0"));
    }
	
}
