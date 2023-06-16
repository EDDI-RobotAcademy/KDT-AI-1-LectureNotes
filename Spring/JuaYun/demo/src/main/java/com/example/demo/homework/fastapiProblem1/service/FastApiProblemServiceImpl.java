package com.example.demo.homework.fastapiProblem1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Slf4j
@Service
public class FastApiProblemServiceImpl implements FastApiProblemService {

    @Override
    public Integer integer(String fastapiRequestUrl) {
        RestTemplate restTemplate = new RestTemplate();

        Integer result = restTemplate.getForObject(
                fastapiRequestUrl,
                Integer.class);

        return result;
    }

}