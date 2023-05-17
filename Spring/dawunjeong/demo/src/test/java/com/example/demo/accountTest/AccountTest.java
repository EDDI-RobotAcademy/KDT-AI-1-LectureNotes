package com.example.demo.accountTest;

import com.example.demo.lectureClass.testCode.account.controller.form.account.AccountRoleRequestForm;
import com.example.demo.lectureClass.testCode.account.controller.form.account.TestAccountLoginResponseForm;
import com.example.demo.lectureClass.testCode.account.controller.form.account.TestAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.controller.form.account.TestAccountWithRoleRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.account.TestAccount;
import com.example.demo.lectureClass.testCode.account.service.account.TestAccountService;
import com.example.demo.lectureClass.testCode.order.controller.form.TestAccountResponseForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AccountTest {

    @Autowired
    private TestAccountService testAccountService;

    @Test
    @DisplayName("사용자가 회원 가입을 할 수 있음")
    void 사용자가_회원_가입한다_refactoring () {
        final String email = "consumer@test.com";
        final String password = "test";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccount account = testAccountService.register(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());

    }
    @Test
    @DisplayName("똑같은 사용자는 회원 가입을 할 수 없음")
    void 이미_존재하는_이메일로_회원_가입시도 () {
        final String email = "test@test.com";
        final String password = "test";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccount account = testAccountService.register(requestForm);

        assertTrue(account == null);
    }

    @Test
    @DisplayName("잘못된 비밀번호 정보를 토대로 로그인")
    void 비밀번호를_틀리게_입력한_상태에서_로그인 () {
        final String email = "test@test.com";
        final String password = "응틀렸어";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseform = testAccountService.login(requestForm);

        assertTrue(responseform.getUserToken() == null);
    }

    @Test
    @DisplayName("이메일을 잘못 입력한 상태로 로그인")
    void 이메일을_틀리게_입력한_상태에서_로그인 () {
        final String email = "gogo@gogo.com";
        final String password = "test";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseform = testAccountService.login(requestForm);

        assertTrue(responseform.getUserToken() == null);
    }
    @Test
    @DisplayName("올바른 입력한 정보를 토대로 로그인")
    void 올바른_정보로_로그인 () {
        // 윈도우의 경우 대소문자 구별이 잘 안되는 문제가 추가로 존재함(이것은 운영체제의 문제)
        final String email = "test@test.com";
        final String password = "test";

        // 로그인을 좀 더 잘 관리하기 위해선 docker 기반의 redis에 token 관리가 필요합니다.
        // token 관리는 Docker redis 및 AWS 설정 이후에 작업해야하므로 잠시 보류합니다.
        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseform = testAccountService.login(requestForm);

        assertTrue(responseform.getUserToken() != null);
    }

    // 로그아웃, 회원 탈퇴와 같은 사항들이 남아있음
    // 이 사항들은 역시나 로그인 되어 있는 token을 기반으로 진행되어야 합니다.
    // 그러므로 위 두 가지 사항은 현 시점에선 보류합니다.

    @Test
    @DisplayName("회원가입을 합니다(일반회원)")
    void 일반회원_회원가입 () {
        // 여러가지 방법론들
        // 1. Account Domain과 AccountRole Domain을 분리하자!
        //    -> 데이터 관점에서는 ok, but 가독성은 4번이 좋다.
        // 2. Account Domain에 회원을 구분할 수 있는 Category ID를 만들자!
        //    -> 회원 정보를 요청했을 때 불필요한 Category ID도 같이 온다.(비용 발생)
        // 3. AccountRole에 Account를 상속 해보자!
        // 4. 일단은 선생님은 1번인데,
        //    선생님 관점에서는 Account와 AccountRole을 분리하되 모두 Account Domain에 배치합니다.
        //    결론적으로 Account Domain Entity에 Account와 AccountRole이 배치됩니다.

        final String email = "business2@test.com";
        final String password = "business2";
        final String role = "business";

        TestAccountWithRoleRequestForm requestForm = new TestAccountWithRoleRequestForm(email, password, role);
        TestAccount account = testAccountService.registerWithRole(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
    }

    @Test
    @DisplayName("일반 회원만 조회하기")
    void 일반회원_조회 () {
        final String role = "NORMAL";

        AccountRoleRequestForm requestForm = new AccountRoleRequestForm(role);
        List<TestAccountResponseForm> normalAccountList = testAccountService.accountListWithRole(role);

        for(TestAccountResponseForm responseForm: normalAccountList) {

            System.out.println("responseForm.getAccountId():  " + responseForm.getAccountId());
            System.out.println("responseForm.getEmail():  " + responseForm.getEmail());

            assertTrue(responseForm.getAccountId() != null);
            assertTrue(responseForm.getEmail() != null);
        }
    }
}
