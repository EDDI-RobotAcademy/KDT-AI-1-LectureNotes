package kr.eddi.demo.lectureClass.fastapi.homework.service;

import kr.eddi.demo.lectureClass.utility.random.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TrafficTestServiceImpl implements TrafficTestService {
    @Override
    public Integer randomNumber() {
        log.info("randomNumber()");
        return CustomRandom.generateNumber(5, 20 + 1);
    }

    @Override
    public Integer randomNumRequest(String fastapiRequestUrl){
        RestTemplate restTemplate = new RestTemplate();

        Integer result = restTemplate.getForObject(
                fastapiRequestUrl,
                Integer.class);

        return result;
    }
}
