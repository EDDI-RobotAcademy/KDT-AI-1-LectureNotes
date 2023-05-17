package com.example.demo.refactorAccountTest;

import com.example.demo.exam.refactorAccount.controller.form.AccountBusinessLoginResponseForm;
import com.example.demo.exam.refactorAccount.controller.form.AccountBusinessRegisterRequestForm;
import com.example.demo.exam.refactorAccount.controller.form.RefactorAccountRegisterRequestForm;
import com.example.demo.exam.refactorAccount.entity.AccountBusiness;
import com.example.demo.exam.refactorAccount.entity.RefactorAccount;
import com.example.demo.exam.refactorAccount.entity.RoleType;
import com.example.demo.exam.refactorAccount.controller.form.RefactorAccountLoginResponseForm;
import com.example.demo.exam.refactorAccount.service.AccountBusinessService;
import com.example.demo.exam.refactorAccount.service.RefactorAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo.exam.refactorAccount.entity.RoleType.BUSINESS;
import static com.example.demo.exam.refactorAccount.entity.RoleType.NORMAL;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class RefactorAccountTest {

    @Autowired
    private RefactorAccountService refactorAccountService;

    @Autowired
    private AccountBusinessService accountBusinessService;


    @Test
    @DisplayName("회원가입 (회원 Role enum 으로 리팩토링)")
    void 회원_가입_enum_타입_Role () {
        final String email = "test@gmail.com";
        final String password = "test";
        final RoleType role = NORMAL;

        RefactorAccountRegisterRequestForm requestForm =
                new RefactorAccountRegisterRequestForm(email, password, role);

        Boolean isSuccess = refactorAccountService.register(
                requestForm.toRefactorAccountRegisterRequest());

        assertTrue(isSuccess);
    }

    /*
        일반회원 및 사업자회원의 로그인이 가능하게 만듭니다.

        Success Criteria
        - 로그인에 필요한 정보를 test 파일에 설정하고 service 를 통해 로그인을 진행할 수 있게 만듭니다.
        - loginForm 을 작성하고 service 를 통해 로그인할 수 있는 코드를 생성합니다.

        To-Do
        - 이메일과 패스워드 어떤 회원인지 설정합니다.
        - 설정된 정보가 맞는지 확인하고 로그인을 시도했을 때 성공했는지 확인합니다.
     */

    @Test
    @DisplayName("일반회원 로그인")
    void 올바른_정보로_로그인 () {
        final String email = "test@test.com";
        final String password = "test";
        final RoleType role = NORMAL;

        RefactorAccountRegisterRequestForm requestForm = new RefactorAccountRegisterRequestForm(email, password, role);
        RefactorAccountLoginResponseForm responseForm = refactorAccountService.login(requestForm);

        assertFalse(responseForm.getUserToken() != null);
    }

    /*
    사업자 계정을 등록할때 사업자번호를 추가로 입력받아 가입하게 합니다.

    Success Criteria
    - 기존 Test 페이지에 비지니스넘버를 추가합니다.
    - service 를 생성하여 가입할 수 있는 Entity, controller, form, repository 룰 생성합니다.
    - test 를 돌렸을때 이메일, 패스워드, 비지니스 넘버가 나오는지 확인합니다.
    - frontend 와 통신할 수 있는 controller 를 생성하여 요청된 정보를 반환합니다.

    To-Do
    - test 에 비지니스 넘버추가
    - 계정을 저장할 수 있는 service 와 entity, form, repository 를 생성하여 test 확인
    - mysql 을 통해 계정이 생성되었는지 확인
    - 확인이 되었다면 frontend 와 통신하는 controller 를 생성하여 요청받은 정보 반환
     */
    @Test
    @DisplayName("사업자 회원가입")
    void 사업자_가입_enum_타입_Role () {
        final String email = "business@gmail.com";
        final String password = "test";
        final Float BUSINESS_NUMBER = 1111111111F;
        final RoleType role = BUSINESS;

        AccountBusinessRegisterRequestForm requestForm =
                new AccountBusinessRegisterRequestForm(email, password, BUSINESS_NUMBER, role);

        AccountBusiness business = accountBusinessService.register(
                requestForm.toAccountBusinessRegisterRequest());

        assertEquals(email, business.getEmail());
        assertEquals(password, business.getPassword());

    }
    @Test
    @DisplayName("사업자 로그인")
    void 올바른_정보로_사업자_로그인 () {
        final String email = "test@test.com";
        final String password = "test";
        final Float BUSINESS_NUMBER = 1111111111F;
        final RoleType role = NORMAL;

        AccountBusinessRegisterRequestForm requestForm = new AccountBusinessRegisterRequestForm(email, password, BUSINESS_NUMBER, role );
        AccountBusinessLoginResponseForm responseForm = accountBusinessService.login(requestForm);

        assertFalse(responseForm.getUserToken() != null);
    }
}
