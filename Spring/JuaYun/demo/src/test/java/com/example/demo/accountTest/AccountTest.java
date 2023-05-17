package com.example.demo.accountTest;

import com.example.demo.lectureClass.testCode.account.controller.form.AccountRoleRequestForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountLoginResponseForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountWithRoleRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import com.example.demo.lectureClass.testCode.account.repository.TestAccountRepository;
import com.example.demo.lectureClass.testCode.account.service.TestAccountService;
import com.example.demo.lectureClass.testCode.order.controller.form.TestAccountResponseForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AccountTest {

    @Autowired
    private TestAccountService testAccountService;

    @Autowired
    private TestAccountRepository testAccountRepository;

//    @Test
//    @DisplayName("사용자가 회원가입 할 수 있음")
//    void 사용자가_회원_가입한다_refactoring () {
//        final String email = "test@test.com";
//        final String password = "test";
//
//        TestAccountRequestForm requestForm = new TestAccountRequestForm(email,password);
//        TestAccount account = testAccountService.register(requestForm);
//
//        assertEquals(email, account.getEmail());
//        assertEquals(password, account.getPassword());
//    }

    @Test
    @DisplayName("잘못된 비밀번호 정보를 토대로 로그인")
    void 이메일만_맞게_입력한_상태에서_로그인 () {
        final String email = "test@test.com";
        final String password = "응틀렸어";
        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);

        assertTrue(responseForm.getUserToken() == null);
    }

    @Test
    @DisplayName("이메일을 잘못 입력한 상태로 로그인")
    void 이메일을_틀리게_입력한_상태에서_로그인 () {
        final String email = "gogo@gogo.com";
        final String password = "응틀렸어";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);

        assertTrue(responseForm.getUserToken() == null);
    }

    @Test
    @DisplayName("올바른 입력한 정보를 토대로 로그인")
    void 올바른_정보로_로그인 () {
        final String email = "test@test.com";
        final String password = "test";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);

        assertTrue(responseForm.getUserToken() != null);
    }

    @Test
    @DisplayName("똑같은 사용자는 회원 가입 할 수 없음")
    void 이미_존재하는_이메일로_회원_가입시도 () {
        final String email = "test@test.com";
        final String password = "test";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email,password);
        TestAccount account = testAccountService.register(requestForm);

        assertTrue(account == null);

        // mysql 로 확인한 결과 오류의 원인은 같은 계정이 두개가 들어가있음
        // create 으로 변경하고 다시 회원가입
        // 다시 오류발생 이번엔 false 가 나와서
        // create 를 update 로 변경하여 돌리면 오류 해결

        // 로그인을 좀 더 관리하기 위해서 docker 기반의 redis 에 token 관리가 필요합니다.
        // token 관리는 Docker redis 및 ABS 설정 이후에 작업해야하므로 잠시 보류합니다.
    }

    @Test
    @DisplayName("회원가입을 합니다(일반회원)")
    void 일반_회원가입 () {
        // 여러가지 방법론들
        // 1. Account Domain 과 AccountRole Domain 을 분리하자
        // 2. Account Domain 에 회원을 구분할 수 있는 Category ID 를 만들자!
        // 3. AccountRole 에 Account 를 상속 해보자
        // 일단 선생님은 1번
        // 선생님의 관점에서는 Account 와 AccountRole 을 분리하되 모두 Account Domain 에 배치합니다.
        // 결론적으로 Account Domain Entity 에 Account 와 AccountRole 이 배치됩니다.
        // 1번과 선생님의 관점의 차이는 생산성

        final String email = "gogo@test.com";
        final String password = "gogo";
        final String role = "NORMAL";

        TestAccountWithRoleRequestForm requestForm = new TestAccountWithRoleRequestForm(email,password, role);
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
        // TestAccountResponseForm 이건 order 에 있음
        // AccountRoleRequestForm requestForm = new AccountRoleRequestForm(role);
        // 이건 사용하지 않아서 주석처리해놔도 상관없음

        for (TestAccountResponseForm responseForm: normalAccountList) {
            System.out.println("responseForm.getAccountId(): " + responseForm.getAccountId());
            System.out.println("responseForm.getEmail(): " + responseForm.getEmail());

            assertTrue(responseForm.getAccountId() != null);
            assertTrue(responseForm.getEmail() != null);
            // getAccountId() 값은 전달할 필요가 없기 때문에 getEmail() 값만 전달하면 됨
        }
    }
}
