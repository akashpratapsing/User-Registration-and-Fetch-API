package com.task.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {

    @Value("${task.openapi.dev-url}")
    private String devUrl;


    @Bean
    public OpenAPI myOpenAPI() {

        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        // Setting contact detail
        Contact contact = new Contact();
        contact.setEmail("aakashprataps832@gmail.com");
        contact.setName("Akash");
        contact.setUrl("https://github.com/akashpratapsing");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Register and Fetch Api")
                .version("1.0")
                .contact(contact)
                .description("This API exposes register and fetch user detail endpoints.").termsOfService("https://github.com/akashpratapsing/User-Registration-and-Fetch-API")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}