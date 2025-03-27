package com.si.responsableapi;  // Vérifie bien que c'est le bon package

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
                registry.addMapping("/api/**")  // Active CORS sur toutes les routes API
                        .allowedOrigins("http://localhost:5173")  // Autorise Vue.js
                        .allowedMethods("GET", "POST", "PUT", "DELETE")  // Méthodes HTTP autorisées
                        .allowedHeaders("*");  // Autorise tous les headers
            }
        };
    }
}
