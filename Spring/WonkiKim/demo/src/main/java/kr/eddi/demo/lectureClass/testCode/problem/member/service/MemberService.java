package kr.eddi.demo.lectureClass.testCode.problem.member.service;


import kr.eddi.demo.lectureClass.testCode.problem.member.controller.form.MemberRequestForm;
import kr.eddi.demo.lectureClass.testCode.problem.member.controller.form.LogInResponseForm;
import kr.eddi.demo.lectureClass.testCode.problem.member.controller.form.MemberResponseForm;
import kr.eddi.demo.lectureClass.testCode.problem.member.entity.Member;

import java.util.List;

public interface MemberService {
    public Member register(MemberRequestForm memberRequestForm);
    public LogInResponseForm logIn(Member member);

    List<MemberResponseForm> serchByRole(String role);
}
