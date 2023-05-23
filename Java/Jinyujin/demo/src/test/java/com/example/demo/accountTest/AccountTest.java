package com.example.demo.accountTest;

import com.example.demo.lectureClass.testCode.account.Service.TestAccountService;
import com.example.demo.lectureClass.testCode.account.controller.form.*;
import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import com.example.demo.lectureClass.testCode.account.repository.TestAccountRepository;
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

    @Test
    @DisplayName("사용자가 회원 가입 할 수 있음")
    void 사용자가_회원_가입한다() {
        final String email = "test@test.com";
        final String password = "test";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        //위 세줄이 컨트롤러에서 리퀘스트 폼이 정보를 받는 구간
//    TestAccountRequest request = requestForm.toTestAccountRequest();
        TestAccount account = testAccountRepository.save(requestForm.toTestAccount());
        // 리퀘스트폼에서 받고 리퀘스트로 받고 다시 엔티티로 받아옴
        // 그리고 리퍼지토리 등록해주기 -> 따로 썼다가 한줄로 줄이심
        // 여기서는 서비스를 불러오지 않으셨네

        // 중간에 리퀘스트로 다시 받는 부분은 왜 필요할까? 확장성
        // 다른 엔티티를 추가할 수 있는 정보가 있기 때문에!
        // RequestForm에는 여러가지 형태가 들어올 수 있고
        // 그 내부에 있는 정보들은 여러가지 Domain 정보를 가질 가능성이 존재함
        // 물론 지금 회원 가입 상황에서는 그다지 필요하지 않긴 함

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());

        // assertEquals로 테스트 확인 -> getter 붙임
        // 이번에는 expected와 actual로 판명하지 않고 바로 email과 getEmail로 확인함

        // 이 테스트에서 Service는 사실상 누락되어 있음
        // 도대체 Service는 왜 필요할까?
        // 요청에 대한 처리를 하기 위해서라는 답변이 나왔음
        // 요청에 대한 처리를 Service에서 할 필요가 있는가?
        // Repository에서 하면 Repository의 목적성에 맞지 않아서라는 답변이 나왔음
        // 결론적으로 Domain Service가 필요한 상황이 만들어짐

        // OOP를 진행함에 있어 DDD는 Damain Entity로만 구현할 수 있다 생각할 수 있음
        // 실제 대부분의 객체지향(OOP) 책에서 하는 이야기가
        // 그냥 class에 데이터 넣고 이 데이터를 제어할 수 있는 메서드를 만들라는 형식으로 설명함
        // 그러나 이렇게 되면 목적성이 불분명해지고 이건 왜 여기서하고
        // 저건 왜 또 여기 있고 하는 상황이 발생하면서 모호성이 발생하기 시작함

        // 실제 Entity는 객체에 해당하며
        // 이 Entity에 모든 메서드를 집어넣는 순간 Entity 자체의 목적성이 불명확해짐
        // 이와 같은 이유로 DB에 저장하는 작업은 Repository로 분리합니다
        // 반면 Service는 조금 더 별개로 생각해야 합니다

        // 사실 이전에도 Java 수업 때 이야기 했던 내용입니다
        // 전구에는 팔이 달려서 지를 키거나 끌 수 없습니다
        // 외부의 요청에 의해 이것을 눌러서 키거나 끄게 되죠
        // 이렇게 Entity 자신이 직접 수행하기 모호한 녀석들을 모두 Service로 빼고
        // 이렇게 뺀 Service들을 Domain Service라고 합니다

        // 마찬가지로 한 번 읽어보라고 했던 study materials의 DDD에 있는 내용입니다

        // Domain Service의 분리는 궁극적으로 어떤 이점을 가져오나요?
        // 재사용성이 올라간다
        // Controller에서 여러 Service를 활용하는 경우가 발생함
        // Service에서 여러 Repository를 활용하는 경우가 발생하기 시작함

        // 위와 같이 분리하지 않고 모든 책에 나온대로
        // Entity에 데이터와 이를 제어하기 위한 메서드를 전부 때려박으면
        // Entity object = new Entity();
        // object.이게뭐야(응몰라.아무거나다해()); 와 같은 코드가 만들어진다
        // 넌뭐하는엔티티.나도몰라(object.이것도한다());
        // 결론적으로 위와 같은 상황을 피하기 위함

        // 쌤이 이거를 ACCOUNTx로 커밋한 이유가 있음
    }

    // Service로 수정
    @Test
    @DisplayName("사용자가 회원 가입 할 수 있음")
    // yaml: create
    void 사용자가_회원_가입한다_refactoring() {
        final String email = "test@test.com";
        final String password = "test";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccount account = testAccountService.register(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
    }

    @Test
    @DisplayName("똑같은 사용자는 회원 가입 할 수 없음")
    // yaml: update
    void 이미_존재하는_이메일로_회원_가입시도() {
        // register가서 findByEmail로 찾아줘야 함

        final String email = "gogo@test.com";
        final String password = "test";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccount account = testAccountService.register(requestForm);

        assertTrue(account == null, "존재하지 않는 이메일입니다. 등록합니다");
        // assertTrue(boolean condition, String message)
        // condition 값이 false이면 junit에러 발생
        // -> message가 있으면 메세지 리턴
        // 이때 message는 test가 fail일 때 나타나는 메세지로
        // 등록된(중복된) 이메일이 아닐 시 fail 처리되면서 등록이 됨(지금 메서드가 그럼)
        // 그리고 다시 한번 test해보면 등록되어 있기에(중복이기에) test pass함
    }

    @Test
    @DisplayName("잘못된 비밀번호 정보를 토대로 로그인")
    void 이메일만_맞게_입력한_상태에서_로그인() {

        final String email = "test@test.com";
        final String password = "응틀렸어";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);
        // 로그인이 되면 userToken을 줌

        assertTrue(responseForm.getUserToken() == null);
    }

    @Test
    @DisplayName("잘못된 이메일 정보를 토대로 로그인")
    void 이메일을_틀리게_입력한_상태에서_로그인() {

        final String email = "gogo@gogo.com";
        final String password = "test";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);

        assertTrue(responseForm.getUserToken() == null);
        // 일단은 get쓰지 않고 폼 만들고 getter를 써서 가져오는 것
        // 인데 이 부분은 계속 수정되었음
        // return값이 null인 경우
    }

    @Test
    @DisplayName("올바르게 입력한 정보를 토대로 로그인")
    void 올바른_정보로_로그인() {
        // 윈도우의 경우 대소문자 구별이 잘 안되는 문제가 추가로 존재함(이것은 운영체제 문제)

        final String email = "test@test.com";
        final String password = "test";

        // 로그인을 좀 더 잘 관리하기 위해선 docker 기반의 redis에 token 관리가 필요합니다.
        // token 관리는 Docker redis 및 AWS 설정 이후에 작업해야하므로 잠시 보류합니다.
        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);

        assertTrue(responseForm.getUserToken() != null);
        // return값이 있는 경우
        // 즉 UUID.randomUUID()값이 userToken에 들어간 경우는 당연히 null이 아닌 것!
    }
    // 로그아웃, 회원 탈퇴와 같은 사항들이 남아있음
    // 이 사항들은 역시나 로그인 되어 있는 token을 기반으로 진행되어야 합니다.
    // 그러므로 위 두 가지 사항은 현 시점에선 보류합니다.

    @Test
    @DisplayName("회원가입을 합니다(일반회원)")
    void 일반회원_회원가입() {
        final String email = "yeah@test.com";
        final String password = "test";
        final String role = "NOLMAL";

        // 정석적으로는 회원가입을 밀어버리고 새로 생성하는게 맞음
        // 지금은 우리가 복습해야하기 때문에 따로 만들어줌

        TestAccountWithRoleRequestForm roleRequestForm = new TestAccountWithRoleRequestForm(email, password, role);
        // 회원가입은 원래 했던 양식 그대로에서 여기서는 role만 추가함
        // 그래서 아이디, 비번 그리고 어떤 회원인지도 전달될 것임

        TestAccount account = testAccountService.registerWithRole(roleRequestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());

        // 그럼 이제 테이블 확인해보면 account 테이블에선ㄴ role값이 없어서 쓸데없는 비용 소비하지 않음
        // role테이블에서만 role을 확인하게 되어 생산성 증가

        // 어제 숙제했던 것과 겹쳐서 오류났었음
        // account_role 테이블에서는 role 뽑을 수 있고
        // test_account에서는 이메일과 패스워드만 뽑을 수 있음

        /*
            여기서 이제 role도 확인하면 좋은데 양방향 참조가 아니라서 확인 못한다고 하심
            -> 이게 몬말이지?
            이메일과 패스워드는 TestAccount 속에 있어서 getter로 가져와서 확인할 수 있지만
            role은 그 안에 구성되어 있지 않음
            그래서 확인 못한다는 것!
         */
    }

    @Test
    @DisplayName("일반 회원만 조회하기")
    void 일반회원_조회() {
        final String role = "NOLMAL";

        // 일반 회원을 조회하려면 관리자 회원이 해야함
        // 원래는 관리자의 유저토큰 가져와서 인증시스템이 있어야 하는데
        // 지금은 일단 관리자회원이라고 가정할 것
//        AccountRoleRequsetForm requsetForm = new AccountRoleRequsetForm(role);
        // 저장소에서 필요한 애들 가져오는 거라서 얘 없어도 됨

        List<TestAccountResponseForm> normalAccountList = testAccountService.accountListWithRole(role);
        // 위에 만들어둔 role을 가지고 accountList를 가져온다
        // List<TestAccount>로 가져오면 비밀번호를 가져오게 됨 이거로 가져오면 안되고
        // 리스폰스 폼에서 필요한 것만 가져오도록 해야함

        for (TestAccountResponseForm responseForm : normalAccountList) {
            System.out.println("responseForm.getAccountId(): " + responseForm.getAccountId());
            System.out.println("responseForm.getEmail(): " + responseForm.getEmail());
            assertTrue(responseForm.getAccountId() != null);
            assertTrue(responseForm.getEmail() != null);
        }
        // 회원가입도 그렇고 조회도 그렇고 같은 형식으로 role만 바꿔주면
        // 일반회원, 사업자회원, 관리자회원을 구분해서 가져올 수 있다
    }
}

