package edu.workshop.todo.todo_console.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // permite todos los endpoints
                    .allowedOrigins("http://localhost:5173") // permite el frontend
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // permite estos métodos HTTP
                    .allowedHeaders("*"); // permite todos los headers
            }
        };
    }
}
