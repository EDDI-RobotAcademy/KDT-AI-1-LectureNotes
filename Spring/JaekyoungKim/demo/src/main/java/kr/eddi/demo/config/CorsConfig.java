package kr.eddi.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "http://127.0.0.1:8080",
                        "http://localhost:8080",
                        "http://192.168.20.3:8080",
                        "http://localhost:3000",
                        "http://localhost:3001",
                        "http://localhost:3004",
                        "http://localhost:3007",
                        "http://localhost:3010",
                        "http://localhost:3012")
                .allowedMethods("GET", "POST", "PUT", "DELETE");


    }
}