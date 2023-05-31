package com.example.demo.problem10;

import com.example.demo.problem10.controller.form.AccountLoginRequestForm;
import com.example.demo.problem10.controller.form.AccountLoginResponseForm;
import com.example.demo.problem10.controller.form.AccountRequestForm;
import com.example.demo.problem10.entity.Account;
import com.example.demo.problem10.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AccountTest {

    /*
    계정 정보를 입력해 회원가입 요청을 합니다. [VAP-1]
    Success Criteria
    1. 계정생성 버튼을 눌러 정보 입력 창을 불러옵니다.
    2. 일반회원 / 사업자회원 선택 합니다.
    3. 계정 정보를 입력합니다.
    4. 완료 버튼을 눌러 회원가입 요청을 전송합니다.
    To-Do
    1. 계정생성 버튼 생성
    2. 회원 구분 Radio Button 생성
    3. 정보 입력 Input 생성 (이메일, 비밀번호, 사업자 번호)
    4. 완료 버튼을 눌렀을 때 Axios를 통해 회원가입 요청 전송

    일반회원가입 요청이 들어오면 받은 정보를 저장합니다. [SAP-1]
    Success Criteria
    1. 회원가입에 필요한 정보(email, password, companyNumber)를 수신합니다.
    2. 이메일 중복 체크를 합니다.
    3. 중복되지 않는다면 정보를 저장합니다.
    4. 회원가입 결과를 리턴합니다.
    To-Do
    1. 일반회원 정보를 저장할 엔티티 생성
    2. 정보 수신할 Controller 생성
    3. Email 중복 검사
    4. Email 중복이 아니라면 수신한 정보 Repository에 저장
 */

    @Autowired
    private AccountService accountService;

    @Test
    @DisplayName("일반 회원 가입")
    void 일반_회원_가입(){
        final String email = "normal1@test.com";
        final String password = "normal";

        AccountRequestForm requestForm = new AccountRequestForm(email, password);
        Account account = accountService.register(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
    }

    @Test
    @DisplayName("사업자 회원 가입")
    void 사업자_회원_가입(){
        final String email = "business1@test.com";
        final String password = "business";
        final Long companyNumber = 1234567890L;

        AccountRequestForm requestForm = new AccountRequestForm(email, password, companyNumber);
        Account account = accountService.register(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
        assertEquals(companyNumber, account.getCompanyNumber());
    }

/*
    이메일과 비밀번호를 입력해 로그인합니다. [VAP-2]
    Success Criteria
    1. 이메일, 비밀번호를 입력합니다.
    2. 로그인 버튼을 눌러 로그인 요청을 전송합니다.
    3. 로그인 결과를 받습니다.
    To-Do
    1. 정보 입력 Input 생성 (이메일, 비밀번호)
    2. 로그인, 취소 버튼 생성
    3. 로그인 버튼을 눌렀을 때 Axios를 통해 로그인 요청 전송

    일반회원가입 요청이 들어오면 받은 정보를 저장합니다. [SAP-2]
    Success Criteria
    1. 로그인에 필요한 정보(email, password)를 수신합니다.
    2. Repository에 email을 검색해서 존재하는지 확인
    3. 존재한다면 password가 일치하는지 확인
    4. 로그인 결과를 리턴합니다.
    To-Do
    1. 정보 수신할 Controller 생성
    2. Email, Password가 Repository에 저장한 값과 일치하는지 검사
    3. 로그인 결과 전송 (계정 id와 사업자회원인지 아닌지)
 */

    @Test
    @DisplayName("회원 로그인")
    void 회원_로그인 () {
        final String email = "test@test.com";
        final String password = "test";

        AccountLoginRequestForm requestForm = new AccountLoginRequestForm(email, password);

        AccountLoginResponseForm responseForm = accountService.login(requestForm);

        assertTrue(responseForm.getId() != null);
    }
}
