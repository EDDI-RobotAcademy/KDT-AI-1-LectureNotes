package kr.eddi.demo.accountTest;

import kr.eddi.demo.testCode.account.controller.form.AccountRoleRequestForm;
import kr.eddi.demo.testCode.account.controller.form.TestAccountLoginResponseForm;
import kr.eddi.demo.testCode.account.controller.form.TestAccountRequestForm;
import kr.eddi.demo.testCode.account.controller.form.TestAccountWithRoleRequestForm;
import kr.eddi.demo.testCode.account.entity.TestAccount;
import kr.eddi.demo.testCode.account.repository.TestAccountRepository;
import kr.eddi.demo.testCode.account.service.TestAccountService;
import kr.eddi.demo.testCode.order.controller.form.TestAccountResponseForm;
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
    @Autowired
    private TestAccountRepository testAccountRepository;
    //회원 관련 테스트
    //보통 순서가 있슴
    @Test
    @DisplayName("사용자가 회원 가입 할 수 있음")
    void 사용자가_회원_가입한다() {
        //테스트용 입력 정보
        final String email = "test@test.com";
        final String password = "test";
        // 넘겨받은 정보를 폼에 넣는다.
        // 폼으로 새 account 생성하여 repository에 저장한다.
        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        // TestAccountRequest request = requestForm.toTestAccountRequest();    // 확장성
        // RequestForm에는 여러가지 형태가 들어올 수 있고
        // 그 내부에 있는 정보들은 여러가지 Domain 정보를 가질 가능성이 존재함
        TestAccount account = testAccountRepository.save(requestForm.toTestAccount());

        assertEquals(email, account.getEmail());
        //앞의 이메일과 생성한 어카운트의 이메일이 같은지 체크한다.
        assertEquals(password, account.getPassword());
        // 앞의 패스워드와  생성한 어카운트의 패스워드가 같은지 체크한다.


        // 이 테스트에서 서비스는 사실상 누락되어 있음
        // 도대체 서비스는 왜 필요한 것인가?
        // 요청에대한 처리를 하기 위헤서라는 답변이 나왔음
        // 요청에 대한 처리를 서비스에서 할 필요가 있는가?
        // repository에서 하면 repository의 목적성에 맞지 않아서
        // 결론적으로 Domain Service가 필요한 상황이 만들어짐
        // DDD는 Domain Entity로만 구현할 수 있다 생각할 수 있음.
        // 실제 대부분의 객체지향 책에서 하는 이야기가
        // 그냥 class에 데이터 넣고 이 데이터를 제어할 수 있는 메서드를 만들라는 형식으로 설명함
        // 그러나 이렇게 되면 목적성이 불분명해지고 이건 왜 여기서하고
        // 저건 왜 또 여기 있고 하는 상황이 발생하면서 모호성이 발생하기 시작함.

        //실제 entity는 객체에 해당하며
        //이 entity에 모든 메서드를 집어넣는 순간 entity 자체의 목적성이 불명확해짐
        // 반면 서비스는 조근 더 별개로 생각해야 합니다.
        // 사실 이전에서 java 수업 때 이야기 했던 내용입니다.
        // 전구에는 팔이 달려서 지를 키거나 끌 수 없습니다.
        // 외부에 요청에 의해 이것을 눌러서 키거나 끄게 되죠.
        // 이렇게 Entity 자신이 수행하기 모호한 녀석드을 모두 Service로 빼고
        // 이렇게 뺀 Service들을 Domain Service라고 합니다.
        // 마찬가지로 한 번 읽어보라고 했던 study materials의 DDD에 있는 내용입니다.

        //Domain Service의 분리는 궁극적으로 어떤 이점을 가져올까요?
        //재상용성이 올라간다.
        // Controller에서 여러 Service를 활요하는 경우가 발생함
        // Service에서 여러 Repository를 활용하는 경우가 발생하기 시작함

        // 위와 같이 분리하지 않고 모든책에 나온대로
        //Entity에 데이터와 이를 제어하기 위한 매서드를 전부 때려박으면
        // Entity object= new Entity();
        // object.블라블라(저기서.이거 불러와) 와 같은 코드가 만들어진다.

    }

    @Test
    @DisplayName("사용자가 회원 가입 할 수 있음")
    void 사용자가_회원_가입한다_refactoring() {
        final String email = "test@test.com";
        final String password = "test";
        // 테스트용 정보들
        //테스트용 정보를 리퀘스트 폼에 넘어 줌
        // 리퀘스트폼을 service의 register 메서드에 넣어 등록해준다.
        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccount account = testAccountService.register(requestForm);
        // 다음 처음에 넣은 값과 같은지 비교해본다.
        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());

    }

    @Test
    @DisplayName("똑같은 사용자는 회원 가입 할 수 없음")
    void 이미_존재하는_이메일로_회원_가입시도() {
        final String email = "test@test.com";
        final String password = "test";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccount account = testAccountService.register(requestForm);
        // 가입 의 경우 중복이 있으면 안되기 때문에 래포지토리에 이미 있는 정보이기 때문에 null을 리턴한다.

        assertTrue(account == null);
    }

    @Test
    @DisplayName("입력한 정보를 토대로 로그인")
    void 이메일만_맞게_입력한_상태에서_로그인() {
        final String email = "test@test.com";
        final String password = "응틀렸어";
        // 틀린 정보로 로그인 해보기
        // 리퀘스트 폼으로 정보를 받아서 서비스의 로그인에 넣어본다.

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);

        assertTrue(responseForm.getUserToken() == null);
        // 잘못된 정보를 넣었기 때문에 널과 같아야 한다.

    }

    @Test
    @DisplayName("올바른 정보를 토대로 로그인")
    void 올바른_입력한_상태에서_로그인() {
        //윈도우의 경우 대소문자 구별이 잘 안되는 문제가 추가로 존재함(이것은 운영체제의 문제)
        final String email = "test@test.com";
        final String password = "test";
        //로그인을 좀 더 잘 관리하기 위해선 docker 기반의  redis에 token 관리가 필요합니다.
        // token 관리는 Docker redis 및 aws 설정 이후에 작업해야 하므로 잠시 보류합니다.

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);

        assertTrue(responseForm.getUserToken() != null);
        // 랜덤 값을 가져오기 때문에 널만 아니면 된다.
    }

    //로그아웃, 회원 탈퇴와 같은 사항들이 남아있음
    //이 사항들은 역시나 로그인 되어있는 토큰을 기반으로 진행되어야 합니다.
    // 그러므로 위 두가지 사항은 현 시점에선 보류합니다.
    @Test
    @DisplayName("회원가입을 합니다(일반회원)")
    void 일반회원_회원가입 () {
        final String email = "gogo@king.com";
        final String password = "gogo";
        final String role = "NORMAL";
        // 롤이 추가된 레퀘스트 폼을 가져온다.
        //가져온 폼을 서비스의 register에 넣어본다.
        TestAccountWithRoleRequestForm requestForm = new TestAccountWithRoleRequestForm(email, password, role);
        TestAccount account = testAccountService.registerWithRole(requestForm);
        // 생성된 어카운트의 이메일과 패스워드가 내가 넣은 것과 같이 같은지 체크한다.
        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
    }

    @Test
    @DisplayName("회원가입을 합니다(일반회원)")
    void 사업자_회원가입 () {
        final String email = "business@test.com";
        final String password = "test";
        final String role = "BUSINESS";
        // 바로 위와 같은 방법으로 진행된다.

        TestAccountWithRoleRequestForm requestForm = new TestAccountWithRoleRequestForm(email, password, role);
        TestAccount account = testAccountService.registerWithRole(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
    }

    @Test
    @DisplayName("일반 회원만 조회하기")
    void 일반회원_조회 () {
        final String role = "BUSINESS";
        // 비지니스 회원 조회한다.
        // 정보를 받을 AccountRoleRequestForm 으로 역할 받는다.
        AccountRoleRequestForm requestForm = new AccountRoleRequestForm(role);
        //서비스의 accountListWithRole()메서드로 실행
        List<TestAccountResponseForm> normalAccountList = testAccountService.accountListWithRole(role);
        // 위에서 리턴 받은 갯수 만큼 반복 할것이다.
        for (TestAccountResponseForm responseForm: normalAccountList) {

            System.out.println("responseForm.getAccountId(): " + responseForm.getAccountId());
            System.out.println("responseForm.getEmail(): " + responseForm.getEmail());
            // 정보는 있는데 id와 email이 비어있으면 잘못 된 것이므로 체크한다.
            assertTrue(responseForm.getAccountId() != null);
            assertTrue(responseForm.getEmail() != null);
        }
    }
}
