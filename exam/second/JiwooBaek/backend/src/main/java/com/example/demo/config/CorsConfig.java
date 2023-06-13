package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://192.168.20.16:8082") // vue는 허용하겠다는 소리
                .allowedOrigins("http://localhost:8082")
                .allowedMethods("GET", "POST", "PUT", "DELETE");

    }
}
