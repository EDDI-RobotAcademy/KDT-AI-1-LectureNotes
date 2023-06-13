package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(
                new MappingJackson2CborHttpMessageConverter());
        return  restTemplate;

        /*
           RestTemplate
           간편하게 Rest 방식 API를 호출할 수 있도록 함
           파이썬에서 FastAPI를 사용하여 HTTP 요청을 보내면 FastAPI는 해당 요청을 처리하고
           요청을 받은 스프링 서버는 RestTemplate를 사용하여 FastAPI에서 받은 데이터를 처리할 수 있음
        */
    }
}

/*
    일단 요청하는 쪽은 vue일 것
    요청하는 건 좋은데 vue가 이걸 할 때 우리는 뭘 해야해?
    뭔가 요청하면 로그인되어 있어야 함
    로그인 검증은? 스프링에서
    그럼 이 시점에서 누가 서버고 누가 클라이언트?
    뷰와의 관계는 스프링이 서버인데
    지금은 스프링이 클라이언트 파이썬이 서버
    영원한 서버는 없음
 */

