package kr.eddi.demo.lectureClass.vue.problem.controller;

import kr.eddi.demo.lectureClass.vue.problem.controller.form.MultiPlayerWinnerResponseForm;
import kr.eddi.demo.lectureClass.vue.problem.controller.form.OrderedFruitsListForm;
import kr.eddi.demo.lectureClass.vue.problem.controller.form.WinnerResponseForm;
import kr.eddi.demo.lectureClass.vue.problem.dice.DiceGameManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/fruits-test")
public class VueProblem3Controller {

    @GetMapping("test")
    public String helloTest () {
        return "Hello, I'm alive!";
    }

    @PostMapping("/calculate")
    public Integer calculateOrderedFruitsList (@RequestBody OrderedFruitsListForm orderedFruitsListForm) {
        log.info("calculateOrderedFruitsList(): " + orderedFruitsListForm);

        final int APPLE_COST = 2000;
        final int WATERMELON_COST = 10000;

        return orderedFruitsListForm.getAppleCount() * APPLE_COST +
                orderedFruitsListForm.getWatermelonCount() * WATERMELON_COST;
    }
}
