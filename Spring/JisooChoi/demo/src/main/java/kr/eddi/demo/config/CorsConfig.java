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
                        "http://127.0.0.1:8080/", // vue는 허용하겠다는 소리
                        "http://localhost:8080/",
                        "http://localhost:3000",
                        "http://localhost:3001", // 뷰 게시판
                        "http://localhost:3002", // 리액트 네비게이션
                        "http://localhost:3004", // 리액트 게시판
                        "http://localhost:3005", // 주스탠드
                        "http://localhost:3006",
                        "http://localhost:3007",
                        "http://localhost:3008",
                        "http://localhost:3010", // 혼자 실습 시작
                        "http://localhost:3011",
                        "http://localhost:3012"
//                        "http://192.168.20.3:8080/"
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}