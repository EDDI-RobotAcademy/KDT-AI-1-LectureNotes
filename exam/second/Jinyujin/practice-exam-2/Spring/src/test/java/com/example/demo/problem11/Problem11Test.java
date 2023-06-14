package com.example.demo.problem11;

// 사용자의 종류엔 일반, 사업자 두 종류가 있습니다.
// 사업자 회원의 경우엔 사업자 등록번호 10자리를 추가로 입력 받도록 합니다.

import com.example.demo.problem11.controller.form.BusinessAccountRequestForm;
import com.example.demo.problem11.controller.form.NormalAccountRegisterRequestForm;
import com.example.demo.problem11.entity.RoleType;
import com.example.demo.problem11.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo.problem11.entity.RoleType.BUSINESS;
import static com.example.demo.problem11.entity.RoleType.NORMAL;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class Problem11Test {

    @Autowired
    private AccountService accountService;

    @Test
    @DisplayName("일반회원 가입")
    void 일반회원_가입하기() {
        final String email = "sexy@test.com";
        final String password = "test";
        final RoleType role = NORMAL;

        NormalAccountRegisterRequestForm normalAccountRegisterRequestForm =
                new NormalAccountRegisterRequestForm(email, password, role);

        Boolean isSuccess = accountService.registerNormalAccount(normalAccountRegisterRequestForm.toAccountRegisterRequest());
        // 이메일 중복 방지
        // 있는 이메일이면 null값 리턴
        // 없는 이메일이면 등록

        assertTrue(isSuccess);
    }

    @Test
    @DisplayName("사업자회원 가입")
    void 사업자회원_가입하기() {
        final String email = "beautiful@test.com";
        final String password = "test";
        final RoleType role = BUSINESS;
        final String businessNumber = "1234567890";

        BusinessAccountRequestForm businessAccountRequestForm =
                new BusinessAccountRequestForm(email, password, role, businessNumber);

        Boolean isSuccess = accountService.registerBusinessAccount(
                businessAccountRequestForm.toBusinessAccountRegisterRequest());

        assertTrue(isSuccess);
    }
}
