package kr.eddi.demo.lectureClass.vue.problem4.controller;

import kr.eddi.demo.lectureClass.vue.problem4.controller.form.GameCreateCharacterForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/game-world")
public class VueProblem4Controller {

    @PostMapping("/create-game-character")
    public Integer createGameCharacterList (@RequestBody GameCreateCharacterForm gameCreateCharacterForm){
        log.info("create-game-character(): " +gameCreateCharacterForm);


        return null;
    }
}
