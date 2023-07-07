package kr.eddi.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate () {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(
                new MappingJackson2CborHttpMessageConverter());
        return restTemplate;
    }
}
