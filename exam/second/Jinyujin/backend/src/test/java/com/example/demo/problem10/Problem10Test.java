package com.example.demo.problem10;

import com.example.demo.problem10.controller.form.AccountWithRoleRequestForm;
import com.example.demo.problem10.controller.form.BusinessNumberRequestForm;
import com.example.demo.problem10.entity.Member;
import com.example.demo.problem10.entity.RoleType;
import com.example.demo.problem10.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo.problem10.entity.RoleType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Problem10Test {
    /*
        백로그 작성
        1. 일반 회원과 사업자 회원을 등록합니다
           - 회원 정보 데이터를 수신합니다
           - 요청 받은 회원 정보가 존재하는지 검사합니다
           - 사업자 회원에게는 사업자 등록번호 10자리를 추가로 입력 받도록 합니다

           To-Do
           - 회원 정보를 수신할 RequestForm을 만들어 줍니다
           - 수신한 Form의 이메일로 중복 여부를 검증합니다
     */

    @Autowired
    private AccountService accountService;

    @Test
    @DisplayName("일반 회원 가입")
    void 일반_회원_회원가입() {

        final String email = "glld@test.com";
        final String password = "test";
        final RoleType roleType = NORMAL;

        AccountWithRoleRequestForm requestForm =
                new AccountWithRoleRequestForm(email, password, roleType);

        Member member = accountService.registerWithRole(requestForm);

        assertEquals(email, member.getEmail());
        assertEquals(password, member.getPassword());
    }
    @Test
    @DisplayName("사업자 회원 가입")
    void 사업자_회원_회원가입() {

        final String email = "rkwk@test.com";
        final String password = "bobo";
        final RoleType roleType = BUSINESS;
        final String businessNumber = "1234567890";

        AccountWithRoleRequestForm requestForm =
                new AccountWithRoleRequestForm(email, password, roleType);

        BusinessNumberRequestForm businessNumberRequestForm = new BusinessNumberRequestForm(businessNumber);

        Member member = accountService.registerWithRoleAndNumber(requestForm, businessNumberRequestForm.getBusinessNumber());
    }
}
