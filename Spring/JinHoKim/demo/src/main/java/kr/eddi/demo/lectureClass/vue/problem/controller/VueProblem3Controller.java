package kr.eddi.demo.lectureClass.vue.problem.controller;

import kr.eddi.demo.lectureClass.vue.problem.controller.form.OrderedFruitsListForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/fruits-test")
public class VueProblem3Controller {

    @PostMapping("/calculate")
    public Integer calculateOrderedFruitsList(@RequestBody OrderedFruitsListForm orderedFruitsListForm) {

        final int APPLE_COST = 2000;
        final int WATERMELON_COST = 10000;

        return orderedFruitsListForm.getAppleCount() * APPLE_COST +
                orderedFruitsListForm.getWatermelonCount() * WATERMELON_COST;
    }
}
