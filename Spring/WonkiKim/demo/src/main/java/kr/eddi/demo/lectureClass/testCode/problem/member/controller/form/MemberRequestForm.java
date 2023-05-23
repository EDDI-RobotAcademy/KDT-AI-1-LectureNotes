package kr.eddi.demo.lectureClass.testCode.problem.member.controller.form;


import kr.eddi.demo.lectureClass.testCode.problem.member.entity.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class MemberRequestForm {
    @Getter
    final String email;
    final String password;
    @Getter
    final String memberRole;
    public Member toMember() {
        return new Member(email, password);
    }

}
