package com.demo.graphql.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    /**
     * Configures Cross-Origin Resource Sharing (CORS) for the application.
     * <p>
     * This configuration allows the application to accept cross-origin requests
     * from a specified frontend URL. It is essential for applications where the
     * frontend and backend are served from different origins.
     *
     * @return A {@link WebMvcConfigurer} instance with CORS configuration.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            /**
             * Configures CORS mapping for all endpoints.
             * <p>
             * This method specifies the allowed origins, HTTP methods, headers, and
             * whether credentials are supported for cross-origin requests. Adjust the
             * allowed origins to match the URL of the frontend application.
             *
             * @param registry The {@link CorsRegistry} used to register CORS configurations.
             */
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000") // Replace with your frontend URL
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
