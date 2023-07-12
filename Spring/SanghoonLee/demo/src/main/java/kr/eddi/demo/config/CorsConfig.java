package kr.eddi.demo.config;

import kr.eddi.demo.lectureClass.utility.property.PropertyUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class CorsConfig implements WebMvcConfigurer {

    final private PropertyUtil propertyUtil;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        final String ALLOWED_ORIGINS = propertyUtil.getProperty("allowed_origins");

        registry.addMapping("/**")
                .allowedOrigins(
                        "http://127.0.0.1:8080",
                        "http://localhost:8080",
                        "http://192.168.20.3:8080",
                        ALLOWED_ORIGINS,
                        "http://localhost:3001",
                        "http://localhost:3004",
                        "http://localhost:3007",
                        "http://localhost:3008",
                        "http://localhost:3009",
                        "http://localhost:3010",
                        "http://localhost:3012")
                .allowedMethods("GET", "POST", "PUT", "DELETE");


    }
}
