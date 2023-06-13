package kr.eddi.demo.lectureClass.fastapi.basics.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class FastApiServiceImpl implements FastApiService{
    @Override
    public void stringRequest(String fastapiRequestUrl) {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(
                fastapiRequestUrl,
                String.class
        );
        log.info("result: " + result);
    }

    @Override
    public Integer integerRequest(String fastapiRequestUrl) {
        RestTemplate restTemplate = new RestTemplate();
        Integer result = restTemplate.getForObject(
                fastapiRequestUrl,
                Integer.class
        );
        return result;
    }
}
