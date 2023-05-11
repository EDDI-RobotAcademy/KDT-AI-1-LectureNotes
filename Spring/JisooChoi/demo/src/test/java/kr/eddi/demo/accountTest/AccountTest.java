package kr.eddi.demo.accountTest;

import kr.eddi.demo.lectureClass.testCode.account.controller.form.TestAccountLoginResponseForm;
import kr.eddi.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm;
import kr.eddi.demo.lectureClass.testCode.account.entity.TestAccount;
import kr.eddi.demo.lectureClass.testCode.account.repository.TestAccountRepository;
import kr.eddi.demo.lectureClass.testCode.account.service.TestAccountService;
import kr.eddi.demo.lectureClass.testCode.order.controller.form.TestOrderRequestForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AccountTest {
    @Autowired
    private TestAccountService testAccountService;
    @Autowired
    private TestAccountRepository testAccountRepository;

    @Test
    @DisplayName("사용자가 회원 가입 할 수 있음")
    void 사용자가_회원_가입한다 () {
        final String email = "test@test.com";
        final String password = "test";
        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccount account = testAccountRepository.save(requestForm.toTestAccount());
        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
    }

    @Test
    @DisplayName("사용자가 회원 가입 할 수 있음")
    void 사용자가_회원_가입한다_refactoring () {
        final String email = "test@test.com";
        final String password = "test";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccount account = testAccountService.register(requestForm);
        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
    }

    @Test
    @DisplayName("똑같은 사용자는 회원 가입 할 수 없음")
    void 이미_존재하는_이메일로_회원_가입시도 () {
        final String email = "test@test.com";
        final String password = "test";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccount account = testAccountService.register(requestForm);

        assertTrue(account == null);
    }

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
        // 윈도우의 경우 대소문자 구별이 잘 안되는 문제가 추가로 존재함(이 것은 운영체제 문제)
        final String email = "test@test.com";
        final String password = "test";

        /*
            로그인을 좀 더 잘 관리하기 위해선 docker 기반의 redis 에 token 관리가 필요합니다.
            token 관리는 Docker redis 및 AWS 설정 이후에 작업해야하므로 잠시 보류합니다.
        */
        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);

        assertTrue(responseForm.getUserToken() != null);

        /*
            로그아웃, 회원 탈퇴와 같은 사항들이 남아있음
            이 사항들은 역시나 로그인 되어 있는 token 을 기반으로 진행되어야 합니다.
            그러므로 위 두가지 사항은 현 시점에선 보류합니다.
        */
    }

    @Test
    @DisplayName("계정 역할에 회원 id를 추가")
    void  계정_역할을_추가 () {
        final String email = "test@test.com";
        final String password = "test";
        final String accountRoll = "일반회원";
        final Long accountId = 1L;

        // 계정 유효성 검사 ?
        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        // 계정의 토큰을 받아와야 하겠지 ? (로그인 임)
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);
        String userToken = responseForm.getUserToken().toString();

        // 계정에 대한 정보를 form 형태로 받아오기
        TestAccountRollRequestForm rollRequestForm = new TestAccountRollRequestForm(accountRoll);

        // 해당 계정 역할에 해당 계정 토큰을 추가해준다. ([accountRoll] id=1, rollName="일반회원", accountId=1)
        // 계정 DB에 해당 역할에 대한 정보를 추가해주는 게 맞는 것 같다. ([account] id=1, email="test@test.com" password="test" ★accountRollId=1)
        TestAccountRollInfoRequestForm accountRollInfoRequestForm = new TestAccountRollInfoRequestForm(userToken, rollRequestForm);
        // 받아온 계정에 대한 기능을 만들어주기
        // (선택된 계정 id를 가리키고 있어라. 토큰이 있긴 한데, 그동안 수업하면서 이렇게 쓰면 안된다고 했지만 일단 썻음)
        TestAccountRoll addAccountRoll = testAccountRollService.addRoll(accountRollInfoRequestForm, accountId);

        assertEquals(accountId, addAccountRoll.getTestAccountRoll().getAccountId());
    }
}