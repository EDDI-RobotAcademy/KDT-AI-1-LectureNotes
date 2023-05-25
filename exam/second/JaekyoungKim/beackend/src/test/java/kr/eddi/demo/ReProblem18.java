package kr.eddi.demo;

import kr.eddi.demo.RefactorAccount.controller.form.RefactorLoginRequestForm;
import kr.eddi.demo.RefactorAccount.service.RefactorAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ReProblem18 {

    @Autowired
    RefactorAccountService accountService;
    @Test
    @DisplayName("로그인 해보기")
    void 회원_로그인(){
        final String email="post@post.com";
        final String password="post";

        RefactorLoginRequestForm requestForm= new RefactorLoginRequestForm(email,password);
        String userToken=accountService.login(requestForm.toAccountLoginRequest());

        assertTrue(userToken!=null);

    }
}
