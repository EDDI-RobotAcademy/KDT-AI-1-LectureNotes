package com.example.demo.FetchTypeTest;

import com.example.demo.lectureClass.fetchType.account.entity.JpaAccount;
import com.example.demo.lectureClass.fetchType.account.form.JpaAccountResponseForm;
import com.example.demo.lectureClass.fetchType.account.form.JpaAccountRoleRequestForm;
import com.example.demo.lectureClass.fetchType.account.form.JpaAccountWithRoleRequestForm;
import com.example.demo.lectureClass.fetchType.account.service.JpaAccountService;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountWithRoleRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AccountLazyFetchTypeTest {

    @Autowired
    private JpaAccountService jpaAccountService;

    @Test
    @DisplayName("FetchType = LAZY, 회원가입")
    void 일반_회원_가입(){
        final String email = "test2@test.com";
        final String password = "gogo";
        final String role = "BUSINESS";


        JpaAccountWithRoleRequestForm requestForm = new JpaAccountWithRoleRequestForm(email, password, role);
        JpaAccount account= jpaAccountService.registerWithRole(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
    }

    @Test
    @DisplayName("일반회원만 조회하기")
    void 일반회원_조회하기(){
        final String role = "NORMAL";
        //사실상 accountTest에서 확인했던 로직과 완벽하게 동일합니다.
        //클래스 이름만 바뀌고 나머지 동작이 전부 완벽하게 동일합니다.
        //그런데 왜 실패할까요? FetchType이 Lazy이기 때문입니다.
        //그럼 Lazy를 빼야할까요? x
        //왜 빼면 안될까요?
        //당장 필요한 것에만 집중하자!!!(결론적으로 이건도 일종의 관심사의 분리입니다.
        //필요없는걸 다가져오는 것을 막는 것이 LAZY
        //막아둔것을 가져오는게 join Fetch
        JpaAccountRoleRequestForm requestForm = new JpaAccountRoleRequestForm(role);
        List<JpaAccountResponseForm> normalAccountList =jpaAccountService.accountListWithRole(role);

        for(JpaAccountResponseForm responseForm : normalAccountList){
            System.out.println("responseForm.getAccountId: " +responseForm.getAccountId() );
            System.out.println("responseForm.getEmail: " +responseForm.getEmail() );
        }

    }
}
