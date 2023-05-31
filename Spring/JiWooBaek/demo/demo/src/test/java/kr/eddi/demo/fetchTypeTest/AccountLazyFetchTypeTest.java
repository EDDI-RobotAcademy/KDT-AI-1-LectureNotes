package kr.eddi.demo.fetchTypeTest;


import com.example.demo.DemoApplication;
import com.example.demo.lectureClass.fetchType.account.controller.form.JpaAccountResponseForm;
import com.example.demo.lectureClass.fetchType.account.controller.form.JpaAccountRoleRequestForm;
import com.example.demo.lectureClass.fetchType.account.controller.form.JpaAccountWithRoleRequestForm;
import com.example.demo.lectureClass.fetchType.account.entity.JpaAccount;
import com.example.demo.lectureClass.fetchType.account.service.JpaAccountService;
import com.example.demo.lectureClass.fetchType.account.controller.form.JpaAccountWithRoleRequestForm;
import com.example.demo.lectureClass.testCode.account.controller.form.AccountRoleRequestForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountWithRoleRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import com.example.demo.lectureClass.testCode.order.controller.form.TestAccountResponseForm;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
public class AccountLazyFetchTypeTest {

    @Autowired
    private JpaAccountService accountService;

    @Test
    @DisplayName("FetchType = LAZY, 일반 회원 가입")
    void 일반_회원_가입 () {
        final String email = "normal@test.com";
        final String password = "test";
        final String role = "NORMAL";

        JpaAccountWithRoleRequestForm requestForm = new JpaAccountWithRoleRequestForm(email, password, role);
        JpaAccount account = accountService.registerWithRole(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
    }
    @Test
    @DisplayName("일반 회원만 조회하기")
    void 일반회원_조회 () {
        // 사실상 accountTest에서 확인했던 로직과 완벽하게 동일합니다.
        // 클래스 이름만 바뀌고 나머지 동작이 전부 완벽하게 동일합니다.
        // 그런데 왜 실패할까요 ? FetchType이 Lazy이기 때문입니다.
        // 그럼 Lazy를 빼야 할까요 ? x
        // 왜 빼면 안될까요 ?
        // 당장 필요한 것에만 집중하자!!! (결론적으로 이것도 일종의 관심사의 분리입니다)
        final String role = "NORMAL";

        JpaAccountRoleRequestForm requestForm = new JpaAccountRoleRequestForm(role);
        List<JpaAccountResponseForm> normalAccountList = accountService.accountListWithRole(role);

        for (JpaAccountResponseForm responseForm: normalAccountList) {
            System.out.println("responseForm.getAccountId(): " + responseForm.getAccountId());
            System.out.println("responseForm.getEmail(): " + responseForm.getEmail());
        }
    }
}
