package kr.eddi.demo.refactorAccountTest;


import com.example.demo.DemoApplication;
import com.example.demo.lectureClass.refactorAccount.controller.form.RefactorAccountRegisterRequestForm;
import com.example.demo.lectureClass.refactorAccount.entity.RoleType;
import com.example.demo.lectureClass.refactorAccount.service.RefactorAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static com.example.demo.lectureClass.refactorAccount.entity.RoleType.BUSINESS;
import static com.example.demo.lectureClass.refactorAccount.entity.RoleType.NORMAL;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
public class RefactorAccountTest {

    @Autowired
    private RefactorAccountService refactorAccountService;

    @Test
    @DisplayName("회원가입 (회원 Role enum으로 리팩토링)")
    void 회원_가입_enum_타입_Role () {
        final String email = "test@gmail.com";
        final String password = "test";
        final RoleType role = NORMAL;

        RefactorAccountRegisterRequestForm requestForm =
                new RefactorAccountRegisterRequestForm(email, password, role);

        Boolean isSuccess = refactorAccountService.register(
                requestForm.toRefactorAccountRegisterRequest());

        assertTrue(isSuccess);
    }
}
