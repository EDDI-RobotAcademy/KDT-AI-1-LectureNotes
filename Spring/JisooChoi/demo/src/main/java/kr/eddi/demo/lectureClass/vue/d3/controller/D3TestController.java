package kr.eddi.demo.lectureClass.vue.d3.controller;

import kr.eddi.demo.lectureClass.utility.random.CustomRandom;
import kr.eddi.demo.lectureClass.vue.d3.controller.form.HealthDataResponse;
import kr.eddi.demo.lectureClass.vue.d3.controller.form.HealthProbResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/d3-test")
public class D3TestController {

    private final int ONE_WEEK = 7;
    private final List<HealthDataResponse> healthDataList = new ArrayList<>();
    private final List<HealthProbResponse> healthProbResponseList = new ArrayList<>();

    @GetMapping("/get-health-info")
    public List<HealthDataResponse> getD3HealthInfo () {
        log.info("getD3HealthInfo()");
        allocHealthData();

        return healthDataList;
    }

    private void allocHealthData() {
        // 리스트 지우기
        healthDataList.clear();

        // 7일 간의 랜덤 헬스 기록, 리스트에 저장
        for (int i = 0; i < ONE_WEEK; i++) {
            /*
                리스트에 랜덤 값을 저장해주고 싶은데, 리스트의 타입이 HealthDataResponse이다.
                그래서 이를 해결하고자 리턴 타입으로 HealthDataResponse을 반환하는 메서드를 만들어 값을 넣었다 !
            */
            healthDataList.add(new HealthDataResponse(CustomRandom.generateNumber(0, 100)));
        }
    }

    @GetMapping("/health-data-prob")
    public List<HealthProbResponse> healthProb () {
        log.info("healthProb()");

        healthProbResponseList.clear();

        for(int i = 0; i < 7; i++){
            healthProbResponseList.add(new HealthProbResponse(CustomRandom.generateNumber(0, 100)));
        }

        return healthProbResponseList;
    }
}
