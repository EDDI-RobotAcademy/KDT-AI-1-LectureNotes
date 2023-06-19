package com.example.demo.lectureClass.homework.problem.vueSpringFastAPI.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class Prob3ServiceImpl implements Prob3Service{

    @Override
    public Integer secondNumRequest(String fastapiRequestUrl) {
        RestTemplate restTemplate = new RestTemplate();
        Integer result = restTemplate.getForObject(
                fastapiRequestUrl,
                Integer.class
        );
        return result;
    }
}
