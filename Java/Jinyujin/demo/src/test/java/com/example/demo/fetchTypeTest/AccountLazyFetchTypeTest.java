package com.example.demo.fetchTypeTest;

import com.example.demo.lectureClass.fetchType.account.controller.form.JpaAccountResponseForm;
import com.example.demo.lectureClass.fetchType.account.controller.form.JpaAccountWithRoleRequestForm;
import com.example.demo.lectureClass.fetchType.account.entity.JpaAccount;
import com.example.demo.lectureClass.fetchType.account.entity.Role;
import com.example.demo.lectureClass.fetchType.account.entity.RoleType;
import com.example.demo.lectureClass.fetchType.account.service.JpaAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.example.demo.lectureClass.fetchType.account.entity.RoleType.ADMIN;
import static com.example.demo.lectureClass.fetchType.account.entity.RoleType.NOLMAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AccountLazyFetchTypeTest {

    @Autowired
    private JpaAccountService accountService;

    @Test
    @DisplayName("FetchType = LAZY, 일반 회원 가입")
    void 일반회원_회원가입() {
        final String email = "gigi@test.com";
        final String password = "test";
        final RoleType roleType = ADMIN;

        JpaAccountWithRoleRequestForm requestForm = new JpaAccountWithRoleRequestForm(email, password, roleType);
        // 일단 리퀘스트폼에서 받아온 데이터를 객체로 생성해줘야 함
        // TestAccountRequestForm인데 여기서는 role까지 포함

        JpaAccount account = accountService.registerWithRole(requestForm);
        // 객체를 받아왔으면 저장소에 저장

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
        // 이제 위에 선언해둔 이메일, 패스워드와 여기서 저장소에 저장한 정보가 맞는지 확인

        /*
        이 상태까지 해서 테스트하면 똑같은데 이제 Lazy때문에 차이 나는게 하나있음
        그걸 볼꺼임

        이제 여기서 조회하기를 만들면 문제생김
         */
    }

    @Test
    @DisplayName("일반 회원만 조회하기")
    void 일반회원_조회() {
        // 사실상 AccountTest에서 확인했던 로직과 완벽하게 동일합니다.
        // 클래스 이름만 바뀌고 나머지 동작이 전부 완벽하게 동일합니다
        // 그런데 왜 실패할까요? JpaAccount 객체의 FetchType이 Lazy이기 때문입니다
        // 그럼 Lazy를 빼야 할까요? 안됨
        // 왜 빼면 안될까요?
        // 당장 필요한 것에만 집중하자!!! (결론적으로 이것도 일종의 관심사의 분리입니다)

        /*
            같은 로직인데 테스트 fail
            fetch 때문인데 붙여야됨

            저장되어 있는 모든 account를 가져오면 안되기 때문에
            Lazy가 없으면 회원이 1억명이라고 할 때 1억명의 account를 다 가져옴
            지금은 필요없는 일은 안하게 하려고 Lazy를 활용하는 것

            회의를 할 때 이것도 해야 해, 저것도 해야 해, 근데 쟤는 어떡하지?
            이러면 제대로된 결론을 내릴 수 없음
            지금 필요없는 거 나한테 요청하지마! 라는게 Lazy

            그러면 조회하라는 상황에서 늦장부림
            -> repository에서 Query를 붙여줘야함
         */

        // 규칙이 있는 repository에서 일단 찾아오고
        // 그 애들과 매칭되는 애들을 accountRepository에서 찾아와야함
        final String role = "NOLMAL";

//        JpaAccountRoleRequsetForm requsetForm = new JpaAccountRoleRequsetForm(role);
        List<JpaAccountResponseForm> normalAccountList = accountService.accountListWithRole(role);
        // JpaAccountResponseForm에는 email과 accountId가 들어있음
        // 거기에서 일반회원리스트만 뽑아오겠다

        for (JpaAccountResponseForm responseForm : normalAccountList) {
            System.out.println("responseForm.getAccountId(): " + responseForm.getAccountId());
            System.out.println("responseForm.getEmail(): " + responseForm.getEmail());

            assertTrue(responseForm.getAccountId() != null);
            assertTrue(responseForm.getEmail() != null);
        }
    }
    /*
        지금까지 제일 중요한건 비용이라고 했음
        동작을 최대한 줄여서 필요한 것만 가져와야 하는 것임
        원래는 account를 다 깔아놓고 그 중에서 매칭되는 애들 찾아왔는데
        Lazy를 쓰면 account를 깔아놓지 않고 필요한 것만 뽑아올 수 있음

        디비에서 연관관계 만들 때는 무조건 Lazy, joinfetch(빨리 일어나서 작업하라는 명령) 붙이기
     */
}
