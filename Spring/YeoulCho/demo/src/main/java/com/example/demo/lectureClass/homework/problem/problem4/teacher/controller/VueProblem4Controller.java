package com.example.demo.lectureClass.homework.problem.problem4.teacher.controller;

import com.example.demo.lectureClass.homework.problem.problem4.teacher.entity.Account;
import com.example.demo.lectureClass.homework.problem.problem4.teacher.entity.CharacterStatus;
import com.example.demo.lectureClass.homework.problem.problem4.teacher.form.AccountCreationForm;
import com.example.demo.lectureClass.homework.problem.problem5.LoginForm;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@Getter
@RequestMapping("/test-account122")
public class VueProblem4Controller {
    private static long accountNumber =1; //전역 어떨때 씁니까? 모두 공유하는 변수
    private static List<Account> accountList =new ArrayList<>();
    private static List<CharacterStatus> characterStatusList =new ArrayList<>();
    @PostMapping("/create") //vue에서 post 했을때 정보가 accountCreationForm으로 들어가)
    public boolean createAccount (@RequestBody AccountCreationForm accountCreationForm){
        log.info("createAccount(): " + accountCreationForm);

        //리스트는 트리 기반의 검색을 합니다.
        //반면 해쉬는 키를 던지면 값을 즉각 반환합니다.
        final Account account = accountCreationForm.toAccount(accountNumber);
        //Account객체 인스턴스 acoount는 accountCreationForm에서 id(accountNumber) 받아서 만든 account가 생성
        accountNumber++; //위 코드다음 accountNumber 증가
        accountList.add(account); //accountList에 account 추가


        final CharacterStatus characterStatus = new CharacterStatus(account.getId());
        characterStatusList.add(characterStatus);
        return true;
    }

    @GetMapping("/get-status")
    public CharacterStatus getCharacterStatus(){
        return characterStatusList.get(0);
    }
    @PostMapping("/test-login")
    public String Login(@RequestBody LoginForm loginForm){
        log.info("loginInfo: " + loginForm);
        String targetUserEmail="";
        for(int i=0; i<accountList.size();i++){
        if(accountList.get(i).getId() == loginForm.getId()){
            targetUserEmail +=accountList.get(i).getUserEmail();
        }}
        return targetUserEmail;
    }
    

}
