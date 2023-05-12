package kr.eddi.demo.lectureClass.testCode.problem.member.service;


import kr.eddi.demo.lectureClass.testCode.problem.member.controller.form.MemberRequestForm;
import kr.eddi.demo.lectureClass.testCode.problem.member.controller.form.MemberResponseForm;
import kr.eddi.demo.lectureClass.testCode.problem.member.entity.Member;

public interface MemberService {
    public Member register(MemberRequestForm memberRequestForm);
    public MemberResponseForm logIn(Member member);
}
