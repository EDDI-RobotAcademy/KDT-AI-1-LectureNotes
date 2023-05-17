package com.example.demo.lectureClass.vue.homework.controller;

import com.example.demo.lectureClass.vue.homework.charactergame.Account;
import com.example.demo.lectureClass.vue.homework.charactergame.CharacterStatus;
import com.example.demo.lectureClass.vue.homework.charactergame.UserCharacterStatusList;
import com.example.demo.lectureClass.vue.homework.controller.form.CharacterGameAccountForm;
import com.example.demo.lectureClass.vue.homework.controller.form.CreateCharacterForm;
import com.example.demo.lectureClass.vue.homework.controller.form.LoginResponseForm;
import com.example.demo.lectureClass.vue.homework.controller.form.FindAccountForm;
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
    private static int characterId = 1;
    private static List<Account> accountList = new ArrayList<>();
    private static List<CharacterStatus> characterStatusList = new ArrayList<>();

    // 회원 가입
    // false이면 이미 등록된 이메일이 있고
    // true이면 회원 가입 진행
    @PostMapping("/add-character")
    public boolean createAccount (@RequestBody CharacterGameAccountForm characterGameAccountForm) {

        // 입력한 이메일과 비밀번호를 log로 보여주기
        log.info("signUp info: " + characterGameAccountForm);

        for(int i = 0; i < accountList.size(); i++) {
            if(accountList.get(i).getEmail().equals(characterGameAccountForm.getEmail())) {
                return false;
            }
        }

        // 입력한 이메일과 비밀번호로 계정을 생성하고, 계정 리스트에 넣어주기
        // 계정 리스트에 넣은 후 log로 보여주기
        Account account = characterGameAccountForm.toAccount(accountNumber);
        accountNumber++;
        accountList.add(account);
        log.info("accountList: " + accountList);

        return true;
    }

    @PostMapping("/create-character-status")
    public UserCharacterStatusList createCharacterStatus (@RequestBody CreateCharacterForm createCharacterForm) {
        log.info("createCharacterForm.getAccountId(): " + createCharacterForm.getAccountId());
        CharacterStatus character = new CharacterStatus(createCharacterForm.getAccountId(), characterId);

        characterStatusList.add(character);

        UserCharacterStatusList userCharacterStatusList =
                new UserCharacterStatusList(characterId,characterStatusList.get(characterId-1).getCharacterStatus());

        characterId++;
        return userCharacterStatusList;
    }

    // 로그인
    @PostMapping("/check-account")
    public LoginResponseForm checkAccount (@RequestBody CharacterGameAccountForm characterGameAccountForm) {
        // 로그인하려고 입력한 이메일과 비밀번호를 log로 보여주기
        log.info("signIn info: " + characterGameAccountForm);

        // 입력한 이메일과 비밀번호를 변수에 할당해주기
        String inputEmail = characterGameAccountForm.getEmail();
        String inputPassword = characterGameAccountForm.getPassword();

        // 입력한 이메일과 비밀번호가 계정 리스트에 있는 이메일과 비밀번호와 일치하는지 확인
        // 일치하면 -> LoginResponseForm의 isSuccessForLogin을 true로, accountId는 해당 계정의 id로 반환하기
        // 일치하지 않으면 -> LoginResponseForm의 isSuccessForLogin을 false로, accountId는 -1로 반환하기
        for(int i = 0; i < accountList.size(); i++) {
            if(inputEmail.equals(accountList.get(i).getEmail())
                    && inputPassword.equals(accountList.get(i).getPassword())) {
                return new LoginResponseForm(true, accountList.get(i).getId());
            }
        } return new LoginResponseForm(false, 0);
    }

    // 로그인한 계정 화면에 띄우기
    @PostMapping("/find-account")
    public String showAccount (@RequestBody FindAccountForm findAccountForm) {
        // 로컬스토리지에 있는 accountId를 인자로 받아서 확인하기
        final int LIST_BIAS = 1;
        String foundAccountEmail = null;

        // 로컬스토리지에 있는 accountId 값으로 
        // 계정 리스트 중 해당 accountId에 맞는 계정의 이메일을 반환하기
        if(accountList.size() > 0){
            foundAccountEmail = accountList.get(findAccountForm.getAccountId()-LIST_BIAS).getEmail();
        }
        return foundAccountEmail;
    }
}
