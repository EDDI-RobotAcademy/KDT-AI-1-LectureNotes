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

    // @Autowired - test에서 @RequiredArgsConstructor 대신 사용하는 또 다른 키워드이다.
    @Autowired
    private JpaAccountService accountService;

    @Test
    @DisplayName("FetchType = LAZY, 일반 회원 가입")
    void 일반_회원_가입 () {
        final String email = "normal@test.com"; // email
        final String password = "test"; // password
        final String role = "NORMAL"; // 역할

        // 프론트에서 정보를 Form(JpaAccountWithRoleRequestForm)으로 받아옴
        // 입력한 email, password, role 대한 객체를 생성함
        JpaAccountWithRoleRequestForm requestForm = new JpaAccountWithRoleRequestForm(email, password, role);
        // requestForm정보를 서비스(accountService)에서 registerWithRole기능을 하고 결과값을 account에 대입
        JpaAccount account = accountService.registerWithRole(requestForm);
        // 입력한 email과 결과값(등록에 대한 기능) Email이 같으면 성공
        assertEquals(email, account.getEmail());
        // 입력한 password와 등록한 password가 같으면 성공
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
        // 서비스에서 role인 회원들을 조회하는 기능
        // 프론트에서 List ResponseForm 타입으로 응답 받고,
        // accountService에서 accountListWithRol기능을 하고, 결과값을 normalAccountList에 대입 한다.
        List<JpaAccountResponseForm> normalAccountList = accountService.accountListWithRole(role);

        // foreach문
        //
        for (JpaAccountResponseForm responseForm: normalAccountList) {
            System.out.println("responseForm.getAccountId(): " + responseForm.getAccountId());
            System.out.println("responseForm.getEmail(): " + responseForm.getEmail());
        }
    }
}
