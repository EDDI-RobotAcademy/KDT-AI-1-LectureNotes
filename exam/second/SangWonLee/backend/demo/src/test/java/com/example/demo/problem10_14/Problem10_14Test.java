package com.example.demo.problem10_14;

import com.example.demo.problem10_14.controller.form.TestBusinessRequestForm;
import com.example.demo.problem10_14.controller.form.TestNormalRequestForm;
import com.example.demo.problem10_14.entity.TestBusinessMember;
import com.example.demo.problem10_14.entity.TestMember;
import com.example.demo.problem10_14.service.TestMemberService;
import com.example.demo.utility.RegistNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

//
//  [ 복합 문제 10 ~ 14 ]
//      사용자의 종류엔 일반, 사업자 두 종류가 있습니다.
//      사업자 회원의 경우엔 사업자 등록번호 10자리를 추가로 입력 받도록 합니다.
//      10. 작업을 진행하기 위한 Backlog를 작성해봅시다!
//      11. 일반 회원 가입 테스트를 작성합니다.
//      12. 사업자 회원 가입 테스트를 작성합니다.
//      13. 검증한 테스트에 대한 Controller를 작성하여 postman으로 테스트합니다.
//      [ 테스트 결과 스크린샷 첨부 ]
//      14. Vue를 통해 위의 회원 가입을 진행할 수 있는 UI 페이지를 작성합니다.

/*
    1. 일반 사용자의 email과 password를 받을 TestNormalRequestForm을 생성합니다.
    2. TestNormalRequestForm 객체로 testMemberService.registerNormalMember 메소드를 실행합니다.
    3. TestNormalMemberRepository 를 생성 후, registerNormalMember 메소드를 실행 했을 때, Jpa로 회원 정보를 저장 합니다.
    4. 사업자 회원의 email과 password, 등록번호 10자리를 추가로 입력받을 TestBusinessRequestForm을 생성합니다.
    5. TestBusinessRequestForm 객체로 testMemberService.registerBusinessMember 메소드를 실행합니다.
    6. TestBusinessMemberRepository 를 생성 후, registerBusinessMember 메소드를 실행 했을 때, Jpa로 회원 정보를 저장 합니다.
    7. postman으로 테스트 합니다.
    8. Vue로 회원 가입을 진행할 수 있는 UI 페이지를 작성합니다.
*/

@SpringBootTest
public class Problem10_14Test {

    @Autowired
    private TestMemberService testMemberService;

    @Test
    @DisplayName("일반회원이 가입 할 수 있음")
    void 일반_회원_가입(){
        final String email = "test@test.com";
        final String password = "test";

        TestNormalRequestForm requestForm = new TestNormalRequestForm(email,password);

        TestMember member = testMemberService.registerNormalMember(requestForm);

        assertEquals(email, member.getEmail());
        assertEquals(password, member.getPassword());

        }

    @Test
    @DisplayName("사업자가 가입 할 수 있음")
    void 사업자_회원_가입(){
        final String email = "BUSINESS@test.com";
        final String password = "test";
        final long registNumber = RegistNumber.getRegistNumber();
        // 랜덤 숫자 10개
        TestBusinessRequestForm requestForm = new TestBusinessRequestForm(email, password, registNumber);

        TestBusinessMember member = testMemberService.registerBusinessMember(requestForm);

        assertEquals(email, member.getEmail());
        assertEquals(password, member.getPassword());
        assertEquals(registNumber, member.getRegistNumber());





    }
}
