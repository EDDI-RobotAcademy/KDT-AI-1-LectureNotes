package kr.eddi.demo.lectureClass.vue.d3.controller;

import kr.eddi.demo.lectureClass.utility.random.CustomRandom;
import kr.eddi.demo.lectureClass.vue.d3.controller.form.HealthDataResponse;
import kr.eddi.demo.lectureClass.vue.d3.controller.form.OtherHealthDataResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/d3-test")
public class D3TestController {

    private final int ONE_WEEK = 7;
    private final List<HealthDataResponse> healthDataList = new ArrayList<>();
    private final List<OtherHealthDataResponse> otherHealthDataList = new ArrayList<>();

    @GetMapping("/get-health-info")
    public List<HealthDataResponse> getD3HealthInfo () {
        log.info("getD3HealthInfo()");

        allocHealthData();

        return healthDataList;
    }

    private void allocHealthData() {
        healthDataList.clear();

        for (int i = 0; i < ONE_WEEK; i++) {
            healthDataList.add(
                    new HealthDataResponse(
                            CustomRandom.generateNumber(0, 100)
                    )
            );
        }
    }

    @GetMapping("/get-other-health-info")
    public List<OtherHealthDataResponse> getOtherD3HealthInfo () {
        log.info("getOtherD3HealthInfo()");

        allocOtherHealthData();

        return otherHealthDataList;
    }

    private void allocOtherHealthData() {
        LocalDate showDate = LocalDate.now();
        otherHealthDataList.clear();

        for (int i = 0; i < ONE_WEEK; i++) {
            otherHealthDataList.add(
                    new OtherHealthDataResponse(
                            CustomRandom.generateNumber(0, 100),
                            showDate.plusDays(i)
                    )
            );
        }
    }
}
