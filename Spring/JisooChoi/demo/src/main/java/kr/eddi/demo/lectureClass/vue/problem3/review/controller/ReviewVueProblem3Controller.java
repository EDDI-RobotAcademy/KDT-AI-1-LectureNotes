package kr.eddi.demo.lectureClass.vue.problem3.review.controller;

import kr.eddi.demo.lectureClass.vue.problem3.review.form.OrderedFruitsListForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/fruits-test")
public class ReviewVueProblem3Controller {

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
