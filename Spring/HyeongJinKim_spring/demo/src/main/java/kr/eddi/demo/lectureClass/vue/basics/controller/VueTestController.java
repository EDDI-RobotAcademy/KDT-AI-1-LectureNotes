package kr.eddi.demo.lectureClass.vue.basics.controller.form;

import kr.eddi.demo.lectureClass.utility.random.CustomRandom;
import kr.eddi.demo.lectureClass.vue.problem.controller.form.AppleResponseForm;
import kr.eddi.demo.lectureClass.vue.problem.controller.form.AppleResponseForm2;
import kr.eddi.demo.lectureClass.vue.problem.controller.form.WatermelonResponseForm;
import kr.eddi.demo.lectureClass.vue.problem.controller.form.WatermelonResponseForm2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vue-test")
public class VueTestController {

    /*
    실제 @RequestMapping("/vue-test")와 @PostMapping("/receive-test")로 URL 경로가 만들어짐
    아래쪽에 있는 @RequestBody를 살펴봐야 합니다.
    객체화된 정보 집합을 받을 때 아래와 같이 @RequestBody를 사용합니다.
    또한 주의할 부분이 있는데 VueRequestTestDataForm은 vue가 전송한 양식을 동일하게 유지하고 있어야 합니다.
    전송한 이름에 해당하는 studentName, studentAge 같은 정보가 정확하게 일치해야 합니다.
     */
    @PostMapping("/receive-test")
    public void receiveTest (@RequestBody VueRequestTestDataForm vueRequestTestDataForm) {
        log.info("received data: " + vueRequestTestDataForm);
    }

    @GetMapping("/get-random-dice")
    public Integer getRandomDice () {
        final int MIN = 1;
        final int MAX = 6;

        log.info("getRandomDice() 요청!");

        return CustomRandom.generateNumber(MIN, MAX);
    }

    @GetMapping("/get-random-dices")
    public List<Integer> getRandomDices () {
        final int MIN = 1;
        final int MAX = 6;
        int DICENUMBER = 2;

        log.info("getRandomDice() 요청!");

        return CustomRandom.generateNumberArr(MIN, MAX, DICENUMBER);
    }

    @GetMapping("/get-hello")
    public String getHello() {
        return "Spring: 나도 안녕";
    }

    @GetMapping("/buy-apple")
    public int buyApple(@RequestParam("appleCountData")Integer appleCountData) {
        AppleResponseForm appleResponseForm = new AppleResponseForm();
        int applesPrice = appleResponseForm.getApplesPrice(appleCountData);
        return applesPrice;
    }
    @GetMapping("/buy-watermelon")
    public int buyWatermelon(@RequestParam("watermelonCountData")Integer watermelonCountData) {
        WatermelonResponseForm watermelonResponseForm = new WatermelonResponseForm();
        int watermelonsPrice = watermelonResponseForm.getWatermelonsPrice(watermelonCountData);
        return watermelonsPrice;
    }
    @PostMapping("/buy-apple2")
    public Integer buyApple2(@RequestBody AppleResponseForm2 appleResponseForm) {
        final int APPLE_COST = 2000;
        return appleResponseForm.getAppleCountData() * APPLE_COST;
    }
    @PostMapping("/buy-watermelon2")
    public Integer buyWatermelon2(@RequestBody WatermelonResponseForm2 watermelonResponseForm) {
        final int WATERMELON_COST = 10000;
        return watermelonResponseForm.getWatermelonCountData() * WATERMELON_COST;
    }
}