package com.example.demo.lectureClass.vue.controller;

import com.example.demo.lectureClass.entity.Account;
import com.example.demo.lectureClass.entity.CharacterStatus;
import com.example.demo.lectureClass.form.AccountCreationForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/test-account")
public class VueProblem4Controller {

    private static Long accountNumber  = 1L;
    private static List<Account> accountList = new ArrayList<>();

    @PostMapping("/create")
    public boolean createAccount (@RequestBody AccountCreationForm accountCreationForm){
        log.info("createAccount(): " + accountCreationForm);

        // 리스트는 트리 기반의 검색을 합니다.
        // 반면 해쉬는 키를 던지면 값을 즉각 반환합니다.

        final Account account = accountCreationForm.toAccount(accountNumber);
        accountNumber++;

        accountList.add(account);

        final CharacterStatus characterStatus =
                new CharacterStatus(account.getId());

        return true;
    }
    @GetMapping("/get-status")
    public CharacterStatus getCharacterStatus() {
        log.info("getCharacterStatus()");

        return null;
    }
}
