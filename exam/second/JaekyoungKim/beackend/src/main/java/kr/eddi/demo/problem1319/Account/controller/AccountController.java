package kr.eddi.demo.problem1319.Account.controller;

import kr.eddi.demo.problem1319.Account.controller.form.AccountLoginResponseForm;
import kr.eddi.demo.problem1319.Account.controller.form.AccountRequestForm;
import kr.eddi.demo.problem1319.Account.controller.form.AccountWithBusinessRoleRequestForm;
import kr.eddi.demo.problem1319.Account.controller.form.AccountWithNormalRoleRequestForm;
import kr.eddi.demo.problem1319.Account.entity.Account;
import kr.eddi.demo.problem1319.Account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/account-test")
public class AccountController {

    final private AccountService accountService;
    /*
    Spring Account Register

    SAR-1- Vue에서 전송받은 정보로 일반 회원 가입을 진행합니다.
    <success criteria>
        1. Vue 에서 넘겨 받은 정보로 리퀘스트폼 생성합니다.
        2. service에서 회원 가입 진행하도록 합니다.
    <to-do>
        1.참 거짓으로 반환 할 것으로 Boolean 타입 매서드 작성
        2.vue 에서 넘겨 받을 정보와 같은 형식의 리퀘스트 폼 만든다.
        3.넘겨 받은 정보록 리퀘스트 생성 합니다.
        4.service에서 register 메서드 진행합니다.
        5. register() 에서 이메일 중복 검사 진행합니다.
        6. 등록 가능 여부에 따라  참 거짓 리턴 한다.

    SAR-2-사업자 회원이 가입합니다.
      <success criteria>
        1. Vue 에서 넘겨 받은 정보로 리퀘스트폼 생성합니다.
        2. service에서 회원 가입 진행하도록 합니다.
    <to-do>
        1.참 거짓으로 반환 할 것으로 Boolean 타입 매서드 작성
        2.vue 에서 넘겨 받을 정보와 같은 형식의 리퀘스트 폼 만든다.
        3.넘겨 받은 정보록 리퀘스트 생성 합니다.
        4.service에서 register 메서드 진행합니다.
        5. register() 에서 이메일과 사업자 등록 번호 중복 검사 진행합니다.
        6. 등록 가능 여부에 따라  참 거짓 리턴 한다.


    */
    @PostMapping("/normal-test")
    public Boolean normalAccountTest(@RequestBody AccountWithNormalRoleRequestForm normalRequestForm ){
        AccountWithNormalRoleRequestForm requestForm = new AccountWithNormalRoleRequestForm
                (normalRequestForm.getEmail(),normalRequestForm.getPassword(),normalRequestForm.getRole());
        Account account = accountService.normalMemberRegister(requestForm);
        return account != null;
    }

    @PostMapping("/business-test")
    public Boolean businessAccountTest(@RequestBody AccountWithBusinessRoleRequestForm businessRoleRequestForm){
        AccountWithBusinessRoleRequestForm requestForm = new AccountWithBusinessRoleRequestForm(
                businessRoleRequestForm.getEmail(),businessRoleRequestForm.getPassword(),businessRoleRequestForm.getRole(),businessRoleRequestForm.getBusinessCode());
        Account account = accountService.businessMemberRegister(requestForm);
        return account != null;
    }
    
    @PostMapping("/login-test")
    public AccountLoginResponseForm accountLogin (@RequestBody AccountRequestForm accountRequestForm){
        AccountRequestForm requestForm=new AccountRequestForm(accountRequestForm.getEmail(), accountRequestForm.getPassword());
        AccountLoginResponseForm responseForm=accountService.login(requestForm);
        return responseForm;
    }
/* 
    
     Spring Account Login

    SAL-1- Vue에서 전송받은 정보로 일반 회원 가입을 진행합니다.
    <success criteria>
        1. Vue 에서 넘겨 받은 정보로 리퀘스트폼 생성합니다.
        2. service에서 로그인 진행하도록 합니다.
    <to-do>
        1. request에 의한 response로  AccountLoginResponseForm 타입 매서드 작성
        2.vue 에서 넘겨 받을 정보와 같은 형식의 리퀘스트 폼 만든다.
        3.넘겨 받은 정보록 리퀘스트 생성 합니다.
        4.service에서 login 메서드 진행합니다.
        5. register() 메서드에서 AccountRepository내에 해당 이메일 존재 여부 검증.
        6. 해당 Account 생성 후에 리퀘스트 패스트워드 같은지 검증한다.
        6. 검증 후 결과 리턴

     */
}
