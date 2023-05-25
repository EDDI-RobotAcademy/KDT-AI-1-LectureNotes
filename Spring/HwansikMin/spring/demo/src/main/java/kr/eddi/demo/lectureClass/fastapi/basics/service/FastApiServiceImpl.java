package kr.eddi.demo.lectureClass.fastapi.basics.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FastApiServiceImpl implements FastApiService {
    @Override
    public void stringRequest(String fastapiRequestUrl) {
        List<HttpMessageConverter<?>> converters = new ArrayList<>();

        converters.add(new FormHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(converters);

        String result = restTemplate.getForObject(
                fastapiRequestUrl,
                String.class);

        log.info("result: " + result);
    }

    @Override
    public Integer integerRequest(String fastapiRequestUrl) {
        RestTemplate restTemplate = new RestTemplate();

        Integer result = restTemplate.getForObject(
                fastapiRequestUrl,
                Integer.class);

        return result;
    }
}