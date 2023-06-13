package com.example.demo.lectureClass.fastapi.basics.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FastApiServiceImpl implements FastApiService{

    @Override
    public void stringRequest(String fastapiRequestUrl) {
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        /*
            HttpMessageConverter
            JSON 데이터를 HTTP 메세지 바디 내 직접 읽거나 쓰는 경우 사용
            왜 사용하는지 아직 이해 못하겠당
        */

        converters.add(new FormHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());
        // form 형태 처리할 때 FormHttpMessageConverter 사용
        // String 형태 처리할 때 StringHttpMessageConverter 사용
        // 외에도 다양한 HttpMessageConverter 형태가 존재
        // 아마 지금 사진이랑 상품 정보 땜에 이거 두개 추가하신 듯?

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
