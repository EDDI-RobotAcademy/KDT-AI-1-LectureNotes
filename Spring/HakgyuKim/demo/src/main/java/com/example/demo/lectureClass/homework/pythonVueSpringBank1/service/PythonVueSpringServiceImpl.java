package com.example.demo.lectureClass.homework.pythonVueSpringBank1.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PythonVueSpringServiceImpl implements PythonVueSpringService{
    @Override
    public Integer integerRequest(String fastapiRequestUrl) {
        RestTemplate restTemplate = new RestTemplate();

        Integer result = restTemplate.getForObject(
                fastapiRequestUrl,
                Integer.class);

        return result;
    }
}
