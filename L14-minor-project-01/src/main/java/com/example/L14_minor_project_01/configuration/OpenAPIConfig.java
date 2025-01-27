package com.example.L14_minor_project_01.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("L14 minor project  API for for product seller, customers ..")
                        .version("1.0")
                        .description("API documentation for product and customer system.")
                        .contact(new Contact().name("Support").url("http://www.example.com").email("nkb2k3cse@gmail.com"))
                );
    }
}

