package com.example.demo.practice.d3plot;

import com.example.demo.lectureClass.utility.random.CustomRandom;
import com.example.demo.lectureClass.vue.d3.controller.form.HealthDataResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequestMapping("/give-me")
@RestController
public class D3PlotController {

    final private List<HealthDataResponse> healthDataList = new ArrayList<>();

    @GetMapping("/health-data")
    public List<HealthDataResponse> giveMeHealthData() {
        log.info("giveMeHealthData()");

//        LocalDate showDate = LocalDate.now();
        LocalDate showDate = LocalDate.of(2023, 04, 27);
        healthDataList.clear();

        for (int i = 0; i < 7; i++) {
            Integer healthData = CustomRandom.generateNumber(1, 100);
            healthDataList.add(new HealthDataResponse(healthData, showDate.plusDays(i)));
        }

        return healthDataList;
        // 이 방식으로 하면 7개의 정보만 오는게 아니라 누적되어 정보가 계속 도착한다
        // 그 누적을 방지해주기 위한 것이 healthDataList.clear();
    }
}

