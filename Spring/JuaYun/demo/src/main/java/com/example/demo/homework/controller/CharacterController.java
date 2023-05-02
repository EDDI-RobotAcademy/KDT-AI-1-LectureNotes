package com.example.demo.homework.controller;

import com.example.demo.homework.problem1.Fruits;
import com.example.demo.homework.problem2.MyCharacterForm;
import com.example.demo.homework.problem2.MyCharacterStatusForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/character-test")
public class CharacterController {

    // public MyCharacterForm characterAccount
    // public 클래스 매서드이름을 생성해줘야 오류가 뜨지 않음
    @PostMapping("/made")
    public MyCharacterForm doResult(@RequestBody MyCharacterForm myCharacterForm) {
        log.info("myCharacterForm: " + myCharacterForm);

        return myCharacterForm;
    }

    @PostMapping("/status")
    // 직접적으로 겟할 폴더를 들고와야 하는거같음
    public MyCharacterStatusForm doPlay (@RequestBody MyCharacterStatusForm myCharacterStatusForm) {
        log.info("myCharacterStatusFrom: " + myCharacterStatusForm);

        return myCharacterStatusForm;
    }
}
