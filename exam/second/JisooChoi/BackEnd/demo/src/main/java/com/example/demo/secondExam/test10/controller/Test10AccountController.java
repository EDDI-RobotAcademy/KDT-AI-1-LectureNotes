package com.example.demo.secondExam.test10.controller;

import com.example.demo.secondExam.test10.controller.form.Test10AccountRequestForm;
import com.example.demo.secondExam.test10.controller.form.Test17AccountLoginResponseForm;
import com.example.demo.secondExam.test10.entity.Test10Account;
import com.example.demo.secondExam.test10.service.Test10AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/exam-test10")
public class Test10AccountController {


    final private Test10AccountService accountService;

    @PostMapping("/register")
    public Test10Account accountRegister(@RequestBody Test10AccountRequestForm requestForm) {
        log.info("accountRegister()");

        final String managerRole = "사업자";
        if(requestForm.getRole().equals(managerRole)){
            log.info("사업자는 추가 Number 를 기입해야 합니다.");

//            final Integer inputRoleNum = 1234567890; // 추가 값은 어떻게 받아오지 ..?
//            requestForm.setManagerRoleNum(inputRoleNum);
        }

        Test10Account account = accountService.register(requestForm);
        return account;
    }

    // 17번 문제
    @PostMapping("/login")
    public Test17AccountLoginResponseForm accountLogin(@RequestBody Test10AccountRequestForm requestForm) {
        log.info("accountLogin()");

        Test17AccountLoginResponseForm memberResponseForm = accountService.login(requestForm);

        return memberResponseForm;
    }

}
