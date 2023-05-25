package kr.eddi.demo;

import kr.eddi.demo.problem1319.Account.controller.form.AccountWithBusinessRoleRequestForm;
import kr.eddi.demo.problem1319.Account.entity.Account;
import kr.eddi.demo.problem1319.Account.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Problem12Test {
    @Autowired
    private AccountService accountService;
    @Test
    @DisplayName("사업자 회원 가입 테스트")
    void 사업자_회원_가입 (){
        final String email = "gogo@naver.com";
        final String password = "gogo";
        final String role = "Business";
        final Integer businessCode=1234567890;

        AccountWithBusinessRoleRequestForm requestForm = new AccountWithBusinessRoleRequestForm(email, password, role, businessCode);
        Account account = accountService.businessMemberRegister(requestForm);
        // 생성된 어카운트의 이메일과 패스워드가 내가 넣은 것과 같이 같은지 체크한다.
        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
    }
}
