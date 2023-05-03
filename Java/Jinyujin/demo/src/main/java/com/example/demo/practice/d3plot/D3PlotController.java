package com.example.demo.practice.d3plot;


import com.example.demo.lectureClass.utility.random.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequestMapping("/give-me")
@RestController
public class D3PlotController {

    final private List<Integer> healthDataList = new ArrayList<>();

    @GetMapping("/health-data")
    public List<Integer> giveMeHealthData() {
        log.info("giveMeHealthData()");

        healthDataList.clear();

        for (int i = 0; i < 7; i++) {
            Integer healthData = CustomRandom.generateNumber(1, 100);;
            healthDataList.add(healthData);
        }

        return healthDataList;
        // 이 방식으로 하면 7개의 정보만 오는게 아니라 누적되어 정보가 계속 도착한다
        // 그 누적을 방지해주기 위한 것이 healthDataList.clear();
    }
}

