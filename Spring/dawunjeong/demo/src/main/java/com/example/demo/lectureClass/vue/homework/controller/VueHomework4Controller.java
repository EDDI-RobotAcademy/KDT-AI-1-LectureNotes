package com.example.demo.lectureClass.vue.homework.controller;

import com.example.demo.lectureClass.vue.homework.charactergame.CharacterModel;
import com.example.demo.lectureClass.vue.homework.controller.form.CharacterGameAccountForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("/character-game")
public class VueHomework4Controller {
    @PostMapping("/add-character")
    public String[] receivedAccountInfo (@RequestBody CharacterGameAccountForm characterGameAccountForm) {
        log.info("received data: " + characterGameAccountForm);

        String[] accountInfo = new String[2];
        accountInfo[0] = characterGameAccountForm.getEmail();
        accountInfo[1] = characterGameAccountForm.getPassword();

        return accountInfo;
    }

    @GetMapping("/create-character-status")
    public int[] createCharacterStatus () {
        CharacterModel character = new CharacterModel();
        int[] characterStatus;
        characterStatus = character.getCharacterStatus();

        log.info("characterStatus: " + Arrays.toString(characterStatus));

        return characterStatus;
    }
}
