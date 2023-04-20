package com.example.demo.lectureClass.vue.homework.controller;

import com.example.demo.lectureClass.vue.homework.charactergame.Account;
import com.example.demo.lectureClass.vue.homework.charactergame.CharacterStatus;
import com.example.demo.lectureClass.vue.homework.controller.form.CharacterGameAccountForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/character-game")
public class VueHomework4Controller {

    private static int accountNumber = 1;
    private static List<Account> accountList = new ArrayList<>();
    private static List<CharacterStatus> characterStatusList = new ArrayList<>();


    @PostMapping("/add-character")
    public CharacterGameAccountForm createAccount (@RequestBody CharacterGameAccountForm characterGameAccountForm) {
        log.info("received data: " + characterGameAccountForm);

        Account account = characterGameAccountForm.toAccount(accountNumber);
        accountNumber++;
        accountList.add(account);

        CharacterStatus character = new CharacterStatus(account.getId());
        characterStatusList.add(character);

        return characterGameAccountForm;
    }

    @GetMapping("/create-character-status")
    public int[] createCharacterStatus () {
        log.info("characterStatus: " + Arrays.toString(characterStatusList.get(0).getCharacterStatus()));
        log.info("whatIsYourId: " + characterStatusList.get(0).getAccountId());

        return characterStatusList.get(0).getCharacterStatus();
    }
}
