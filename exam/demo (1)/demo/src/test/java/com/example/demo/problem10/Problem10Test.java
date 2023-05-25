package com.example.demo.problem10;

import com.example.demo.Problem10SignIn.controller.form.AccountLoginRequestForm;
import com.example.demo.Problem10SignIn.controller.form.AccountRequestForm;
import com.example.demo.Problem10SignIn.entity.BusinessNumber;
import com.example.demo.Problem10SignIn.entity.CategoryType;
import com.example.demo.Problem10SignIn.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static com.example.demo.Problem10SignIn.entity.CategoryType.BUSINESS;
import static com.example.demo.Problem10SignIn.entity.CategoryType.NORMAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class Problem10Test {

    @Autowired
    private AccountService accountService;
//    @Test
//    @DisplayName("일반 사용자만 회원가입")
//    void 일반_회원가입 () {
//        /*
//        사용자의 종류엔 일반, 사업자 두 종류가 있습니다.
//        사업자 회원의 경우엔 사업자 등록번호 10자리를 추가로 입력 받도록 합니다.
//
//        회원이 있고 회원은 두종류
//        일반과 사업자 종류
//        사업자 종류는 가입 할때 사업자 번호가 필요함
//         */
//
//        final String email = "gogo@gogo.com";
//        final String password = "gogo";
//
//        AccountRequestForm requestForm = new AccountRequestForm(email, password);
//        boolean isSuccess = accountService.register(requestForm);
//
//        assertTrue(isSuccess);
//    }
    /*
        타입으로 일반과 사업자를 구별 하려니까
        account 모델이 두개로 나뉘어짐
        category type을 넣어 리펙토링 필요
     */
//    @Test
//    @DisplayName("사업자 회원 가입")
//    void 사업자_회원가입 () {

//        final String email = "business@business.com";
//        final String password = "business";
//        final AccountType accountType = BUSINESS;
//        final int businessNumber = 0000000000;
//    }
    @Test
    @DisplayName("일반 사용자만 회원가입_리펙토링")
    void 일반_회원가입_리펙토링 () {
        /*
        사용자의 종류엔 일반, 사업자 두 종류가 있습니다.
        사업자 회원의 경우엔 사업자 등록번호 10자리를 추가로 입력 받도록 합니다.

        회원이 있고 회원은 두종류
        일반과 사업자 종류
        사업자 종류는 가입 할때 사업자 번호가 필요함
         */

        final String email = "gogo8@gogo.com";
        final String password = "gogo";
        final CategoryType categoryType = NORMAL;
        final int businessNumber = 00000000;

        AccountRequestForm requestForm = new AccountRequestForm(email, password, categoryType, businessNumber);
        boolean isSuccess = accountService.register(requestForm.toAccountRequest());

        assertTrue(isSuccess == true);
    }
    @Test
    @DisplayName("사업자 회원 가입")
    void 사업자_회원가입 () {
        final String email = "business@business.com";
        final String password = "business";
        final CategoryType categoryType = BUSINESS;
        final int businessNumber = 12345678;

        AccountRequestForm requestForm = new AccountRequestForm(email, password, categoryType, businessNumber);
        boolean isSuccess = accountService.register(requestForm.toAccountRequest());

        assertTrue(isSuccess == true);
    }
    @Test
    @DisplayName("회원의 로그인")
    String 로그인하기 () {
        /*
        저장소 안에 이메일 비밀번호가 맞는지 확인
        findbyid로 가져 온다음 각각 확인
         */

        final String email = "test@test.com";
        final String password = "test";
        final int randomInteger = 123;

        AccountLoginRequestForm requestForm = new AccountLoginRequestForm(email, password, randomInteger);
        String isSuccess = accountService.login(requestForm.toAccountLoginRequest()).getUniqueRandomName();
        return isSuccess;

    }
}
