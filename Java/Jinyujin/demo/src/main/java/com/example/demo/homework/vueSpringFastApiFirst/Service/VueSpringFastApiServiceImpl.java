package com.example.demo.homework.vueSpringFastApiFirst.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class VueSpringFastApiServiceImpl implements VueSpringFastApiService{
    @Override
    public Integer integerRequest(String fastapiRequestUrl) {

        RestTemplate restTemplate = new RestTemplate();

        Integer result = restTemplate.getForObject(
                fastapiRequestUrl,
                Integer.class);

        return result;
    }
}
