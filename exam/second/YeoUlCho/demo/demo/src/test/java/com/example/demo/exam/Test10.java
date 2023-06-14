package com.example.demo.exam;

import com.example.demo.problem10_14.entity.Member;
import com.example.demo.problem10_14.entity.RoleType;
import com.example.demo.problem10_14.form.MemberRegisterRequestForm;
import com.example.demo.problem10_14.repository.MemberRepository;
import com.example.demo.problem10_14.service.MemberRegisterRequest;
import com.example.demo.problem10_14.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo.problem10_14.entity.RoleType.BUSINESS;
import static com.example.demo.problem10_14.entity.RoleType.NORMAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class Test10 {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("일반회원가입하기")
    public void 일반_회원가입(){
        // 일반회원가입 정보는 email, password, name을 받는다
        // 프론트에서 가입하려는 회원의 정보를 받을 requestForm을 작성한다
        // 받은 requestForm을 저장한다.
        // 넣은 값과 저장된 값이 일치하는지 확인한다.


        final String name ="YU";
        final String email ="YU@test.com";
        final String password ="YUuu";
        final RoleType roleType = NORMAL;
        final Integer businessNumber=0;

        MemberRegisterRequestForm requestForm = new MemberRegisterRequestForm(name, email, password, roleType,businessNumber);
        MemberRegisterRequest request= requestForm.toMemberRegisterRequest();
        boolean isMember = memberService.register(request);

        assertTrue(isMember);
    }

    @Test
    @DisplayName("사업자회원 가입하기")
    public void 사업자_회원가입(){
        final String name ="YU";
        final String email ="YU@test.com";
        final String password ="YUuu";
        final RoleType roleType = BUSINESS;
        final Integer businessNumber=1234567899;

        MemberRegisterRequestForm requestForm = new MemberRegisterRequestForm(name, email, password, roleType,businessNumber);
        MemberRegisterRequest request= requestForm.toMemberRegisterRequest();
        boolean isMember = memberService.register(request);

        assertTrue(isMember);

    }
}
