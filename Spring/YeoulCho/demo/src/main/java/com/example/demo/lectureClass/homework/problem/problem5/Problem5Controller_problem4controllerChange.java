package com.example.demo.lectureClass.homework.problem.problem5;


import com.example.demo.lectureClass.homework.problem.problem4.teacher.entity.Account;
import com.example.demo.lectureClass.homework.problem.problem4.teacher.entity.CharacterStatus;
import com.example.demo.lectureClass.homework.problem.problem4.teacher.form.AccountCreationForm;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@Getter
@RequestMapping("/test-account")
public class Problem5Controller_problem4controllerChange {

    private static long accountNumber = 1; //전역 어떨때 씁니까? 모두 공유하는 변수
    private static Map<Long, Account> accountMap = new HashMap<>();
    private static Map<Long, CharacterStatus> characterStatusMap = new HashMap<>();

    @PostMapping("/create") //vue에서 post 했을때 정보가 accountCreationForm으로 들어가)
    public boolean createAccount(@RequestBody AccountCreationForm accountCreationForm) {
        log.info("createAccount(): " + accountCreationForm);


        final Account account = accountCreationForm.toAccount(accountNumber);
        accountMap.put(accountNumber++, account);


        final CharacterStatus characterStatus = new CharacterStatus(account.getId());
        characterStatusMap.put(accountNumber, characterStatus);
        return true;
    }

    @GetMapping("/get-status")
    public CharacterStatus getCharacterStatus() {
        return characterStatusMap.get(accountNumber);
    }

    @PostMapping("/test-login")
    public LoginResponseForm Login(@RequestBody LoginForm loginForm) {
        log.info("loginInfo: " + loginForm);

        log.info(accountMap.toString());
        log.info(String.valueOf(loginForm.getId()));
        log.info(String.valueOf(accountMap.get(Long.valueOf(loginForm.getId()))));

        String targetUserEmail = accountMap.get(loginForm.getId()).getUserEmail();

        log.info(targetUserEmail);
        LoginResponseForm loginResponseForm=null;
        if (accountMap.containsKey(loginForm.getId())) {
            loginResponseForm = new LoginResponseForm(targetUserEmail);
        }

        return loginResponseForm;
    }

} //todo 수정하라 캐릭터고를 수 있게
//    @GetMapping("/choose-character")
//    public ChooseCharacter chooseCharacter(){
//        HashMap<Long, Object> characterMap = new HashMap<>();
//        return characterStatusList.get(0)
//
//    }
//
//}
//String,String> map2 = new HashMap<>();