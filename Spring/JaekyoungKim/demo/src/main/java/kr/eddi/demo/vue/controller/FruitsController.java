package kr.eddi.demo.vue.controller;

import kr.eddi.demo.vue.controller.form.FruitsForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/fruits-test")
public class FruitsController {
    @PostMapping("/fruits-calculate")
    public Integer fruitsCalculate(@RequestBody FruitsForm fruitsForm){
        log.info("사과의 양"+fruitsForm);
        final int APPLE_COST = 2000;
        final int GRAPE_COST = 10000;

        return fruitsForm.getAppleAmount() * APPLE_COST +
                fruitsForm.getGrapeAmount() * GRAPE_COST;
    }
     
    
    
}
