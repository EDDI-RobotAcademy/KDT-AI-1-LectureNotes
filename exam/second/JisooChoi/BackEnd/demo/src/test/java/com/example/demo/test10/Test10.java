package com.example.demo.test10;

import com.example.demo.secondExam.test10.controller.form.Test10AccountRequestForm;
import com.example.demo.secondExam.test10.controller.form.Test17AccountLoginResponseForm;
import com.example.demo.secondExam.test10.entity.Test10Account;
import com.example.demo.secondExam.test10.service.Test10AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    해당 파일에 함께 풀어져 있는 문제입니다.

    11번, 12번 => 13번 확인
    18번 => 19번 확인
*/
@SpringBootTest
public class Test10 {

    @Autowired
    private Test10AccountService accountService;

    @Test
    @DisplayName("URL 맵핑을 통해 사용자 정보가 요청되면 회원가입이 됩니다.")
    void 일반_사용자가_회원가입을_합니다 () {
        final String email = "test@test.com";
        final Integer password = 1234;
        final String role = "일반";
        final Integer roleAddNum = null;

        // Form 으로 받기
        Test10AccountRequestForm requestForm = new Test10AccountRequestForm(email, password, role, roleAddNum);

        // 증복 검사
        Test10Account account = accountService.register(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
        assertEquals(role, account.getRole());
    }

    @Test
    @DisplayName("URL 맵핑을 통해 사용자 정보가 요청되면 회원가입이 됩니다.")
    void 사업자_사용자가_회원가입을_합니다 () {
        final String email = "manager222@test.com";
        final Integer password = 1234;
        final String role = "사업자";
        final Integer roleAddNum = null;

        final String managerRole = "사업자";

        // Form 으로 받기
        Test10AccountRequestForm requestForm = new Test10AccountRequestForm(email, password, role, roleAddNum);

        // 계정이 사용자인 것 확인하고 10개의 숫자 추가로 받기
        // -> setter 를 없애면서 필요없어진 부분
//        if(requestForm.getRole().equals(managerRole)){
//            final Integer inputRoleNum = 1234567890; // 처음에는 없다가 추가로 기입 받음
//            requestForm.setManagerRoleNum(inputRoleNum);
//        }

        // 증복 검사
        Test10Account account = accountService.register(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
        assertEquals(role, account.getRole());
    }

    @Test
    @DisplayName("회원의 계정 정보가 수신되면 존재여부에 따라 로그인이 됩니다.")
    void 사용자가_로그인을_합니다 () {
        final String email = "test@test.com";
        final Integer password = 1234;
        final String role = "일반";
        final Integer roleAddNum = null;

        Test10AccountRequestForm requestForm =
                new Test10AccountRequestForm(email, password, role, roleAddNum);

        Test17AccountLoginResponseForm memberResponseForm = accountService.login(requestForm);

        assertTrue(memberResponseForm.getUserToken() != null);
    }
}
