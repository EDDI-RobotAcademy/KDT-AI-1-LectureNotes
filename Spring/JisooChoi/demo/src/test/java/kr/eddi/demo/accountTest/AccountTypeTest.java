package kr.eddi.demo.accountTest;

import kr.eddi.demo.lectureClass.testCode.account.controller.form.TestTypeAccountRequestForm;
import kr.eddi.demo.lectureClass.testCode.account.entity.TestAccountType;
import kr.eddi.demo.lectureClass.testCode.account.service.TestTypeAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AccountTypeTest {

    @Autowired
    private TestTypeAccountService typeAccountService;

    @Test
    @DisplayName("사용자가 회원 가입 할 수 있음")
    void 사용자가_회원_가입을_하면서_회원_유형이_결정된다 () {
        final String email = "user@user.com";
        final String password = "user";
        final String type = "일반회원";

        TestTypeAccountRequestForm requestForm =
                new TestTypeAccountRequestForm(email, password, type);
        TestAccountType account = typeAccountService.register(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
        assertEquals(type, account.getType());
    }
}
