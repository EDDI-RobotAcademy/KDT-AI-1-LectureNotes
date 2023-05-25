package kr.eddi.demo;


import kr.eddi.demo.RefactorAccount.controller.form.RefactorAccountRequestForm;
import kr.eddi.demo.RefactorAccount.entity.RoleType;
import kr.eddi.demo.RefactorAccount.service.RefactorAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static kr.eddi.demo.RefactorAccount.entity.RoleType.BUSINESS;
import static kr.eddi.demo.RefactorAccount.entity.RoleType.NORMAL;
import static org.junit.jupiter.api.AssertTrue.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class ReProblem11 {

    @Autowired
    private RefactorAccountService accountService;

    @Test
    @DisplayName("일반 회원 가입")
    void 일반_회원_가입 (){
        final String email ="post@post.com";
        final String password="post";
        final RoleType role=NORMAL;
        RefactorAccountRequestForm requestForm=new RefactorAccountRequestForm(email,password,role);
        Boolean isSuccess=accountService.refactorRegister(requestForm.toAccountRegisterRequest());
        assertTrue(isSuccess);

    }
    @Test
    @DisplayName("사업자 회원 가입")
    void 사업자_회원_가입(){
        final String email ="busy@post.com";
        final String password="busy";
        final RoleType role=BUSINESS;
        RefactorAccountRequestForm requestForm= new RefactorAccountRequestForm(email,password,role);
        Boolean isSuccess= accountService.refactorRegister(requestForm.toAccountRegisterRequest());
        assertTrue(isSuccess);
    }



}
