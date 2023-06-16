package com.example.demo.lectureClass.fastapi.homework.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class FastApiHomeworkServiceImpl implements FastApiHomeworkService{
    @Override
    public Integer secondNumberRequest(String fastapiRequestUrl) {
        RestTemplate restTemplate = new RestTemplate();

        Integer result = restTemplate.getForObject(
                fastapiRequestUrl,
                Integer.class);

        return result;
    }
}
