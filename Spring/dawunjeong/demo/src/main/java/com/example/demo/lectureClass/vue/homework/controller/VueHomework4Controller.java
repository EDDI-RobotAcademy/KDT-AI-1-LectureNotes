package com.example.demo.lectureClass.vue.homework.controller;

import com.example.demo.lectureClass.vue.homework.charactergame.Account;
import com.example.demo.lectureClass.vue.homework.charactergame.CharacterStatus;
import com.example.demo.lectureClass.vue.homework.controller.form.CharacterGameAccountForm;
import com.example.demo.lectureClass.vue.homework.controller.form.SelectAccountForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/character-game")
public class VueHomework4Controller {

    private static int accountNumber = 0;
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

    @PostMapping("/check-account")
    public String checkAccount (@RequestBody CharacterGameAccountForm characterGameAccountForm) {
        log.info("received data: " + characterGameAccountForm);
        String yourEmail = characterGameAccountForm.getEmail();
        String registeredEmail = accountList.get(0).getEmail();
        if(yourEmail.equals(registeredEmail)) {
            yourEmail = characterGameAccountForm.getEmail();
        } else {
            yourEmail = null;
        }
        return yourEmail;
    }
    @PostMapping("/get-account")
    public int showAccount (@RequestBody SelectAccountForm selectAccountForm) {
        log.info("showAccount");
        log.info("selectAccountForm.getAccountId(): " + selectAccountForm.getAccountId());
        log.info("accountList.get(selectAccountForm.getAccountId()): " + accountList.get(selectAccountForm.getAccountId()));
        int selectedAccount = accountList.get(selectAccountForm.getAccountId()).getId();
        return selectedAccount;
    }
}
