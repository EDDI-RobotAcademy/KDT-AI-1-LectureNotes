package com.example.demo.practice.d3plot;


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

    @GetMapping("/health-data")
    public List<Integer> giveMeHealthData() {
        log.info("giveMeHealthData()");

        List<Integer> healthDataList = new ArrayList<>();
        healthDataList.add(35);
        healthDataList.add(53);
        healthDataList.add(76);
        healthDataList.add(26);
        healthDataList.add(57);
        healthDataList.add(95);
        healthDataList.add(16);

        return healthDataList;
    }
}

