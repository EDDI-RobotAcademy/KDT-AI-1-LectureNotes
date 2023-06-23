package kr.eddi.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:8080",
                        "http://localhost:8080",
                        "http://localhost:3000",
                        "http://localhost:3001",
                        "http://localhost:3004",
                        "http://localhost:3005",
                        "http://localhost:3010",
                        "http://localhost:3015") // 보안에서 vue는 허용하겠다.
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
