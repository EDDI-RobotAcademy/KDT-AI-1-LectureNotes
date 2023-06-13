package com.example.demo.fetchTypeTest;

import com.example.demo.lectureClass.fetchType.account.controller.form.JpaAccountResponseForm;
import com.example.demo.lectureClass.fetchType.account.controller.form.JpaAccountRoleRequestForm;
import com.example.demo.lectureClass.fetchType.account.controller.form.JpaAccountWithRoleRequestForm;
import com.example.demo.lectureClass.fetchType.account.entity.JpaAccount;
import com.example.demo.lectureClass.fetchType.account.service.JpaAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
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

    // 일반회원 조회를 할 때 패치에서는 우리가 했던 방식 그대로 가져오면 문제가 생김
    // 왜일까?
    // 사실상 accountTest 에서 확ㅇ니했던 로직과 완벽하게 동일합니다.
    // 클래스 이름만 바뀌고 나머지 동작이 전부 완벽하게 동일합니다
    // 그런데 왜 실패할까요? FetchType 이 Lazy 이기 때문입니다.

    // 그럼 Lazy 를 빼야 할까요?
    // 왜 빼면 안될까요?

    // 당장 필요한 것에만 집중하자! (결론적으로 이것도 일종의 관심사의 분리입니다.)
    // 돈이 문제임
    // 필요한 것만 가져오자

    @Test
    @DisplayName("일반 회원만 조회하기")
    void 일반회원_조회 () {
        final String role = "NORMAL";

//        JpaAccountRoleRequestForm requestForm = new JpaAccountRoleRequestForm(role);
        List<JpaAccountResponseForm> normalAccountList = accountService.accountListWithRole(role);

        for (JpaAccountResponseForm responseForm: normalAccountList) {
            System.out.println("responseForm.getEmail(): " + responseForm.getEmail());
        }
    }
}