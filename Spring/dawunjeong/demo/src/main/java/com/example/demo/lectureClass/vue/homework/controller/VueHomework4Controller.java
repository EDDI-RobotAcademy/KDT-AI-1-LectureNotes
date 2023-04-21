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
        log.info("signUp info: " + characterGameAccountForm);

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
    public boolean checkAccount (@RequestBody CharacterGameAccountForm characterGameAccountForm) {
        log.info("signIn info: " + characterGameAccountForm);
        String inputEmail = characterGameAccountForm.getEmail();
        String inputPassword = characterGameAccountForm.getPassword();

        boolean isRegisteredUser = false;

        for(int i = 0; i < accountList.size(); i++) {
            if(inputEmail.equals(accountList.get(i).getEmail()) && inputPassword.equals(accountList.get(i).getPassword())) {
                isRegisteredUser = true;
            } log.info("isRegisteredUser: " + isRegisteredUser);
        } return isRegisteredUser;
    }

    @PostMapping("/get-account")
    public int showAccount (@RequestBody SelectAccountForm selectAccountForm) {
        int selectedAccount = accountList.get(selectAccountForm.getAccountId()).getId();
        return selectedAccount;
    }
    @PostMapping("/get-account-list")
    public List<Account> showAccountList (@RequestBody CharacterGameAccountForm characterGameAccountForm) {
        List<Account> yourAccountList = new ArrayList<>();

        for(int i = 0; i < accountList.size(); i++) {
            if(characterGameAccountForm.getEmail().equals(accountList.get(i).getEmail())) {
                yourAccountList.add(accountList.get(i));
            }
        }
        return yourAccountList;
    }
}
