package com.todo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    // Configure CORS (Cross-Origin Resource Sharing) mappings
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow CORS for all endpoints
        registry.addMapping("/**")
                // Allow requests from any origin
                .allowedOriginPatterns("*")
                // Allow specified HTTP methods
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                // Allow all headers
                .allowedHeaders("*")
                // Allow credentials (e.g., cookies, authorization headers)
                .allowCredentials(true);
    }
}
