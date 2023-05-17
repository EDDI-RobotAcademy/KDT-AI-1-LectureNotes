package com.example.demo.lectureClass.vue.d3.homework.controller;

import com.example.demo.lectureClass.untility.random.CustomRandom;
import com.example.demo.lectureClass.vue.d3.homework.controller.form.D3HealthDataResponseForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/give-me")
public class D3HomeworkController {

    final List<D3HealthDataResponseForm> healthDataList = new ArrayList<>();
    @GetMapping("/healthData")
    public List<D3HealthDataResponseForm> getHealthData () {
        healthDataList.clear();

        for(int i = 1; i < 8; i++){
            healthDataList.add(
                    new D3HealthDataResponseForm("2023-05-"+i,
                            CustomRandom.generateNumber(0,100)));
        }
        log.info("healthDataList: " + healthDataList);
        return healthDataList;
    }
}
