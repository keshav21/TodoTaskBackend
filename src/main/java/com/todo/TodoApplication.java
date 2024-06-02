package com.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoApplication {

	// Main method to start the Spring Boot application
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	// Customizes the configuration of the web server
	@Bean
	public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
		// Sets the port of the web server to 5000
		return factory -> factory.setPort(5000);
	}
}
