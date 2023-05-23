package com.example.demo.lectureClass.homework.problem.testCode.form;

import com.example.demo.lectureClass.homework.problem.testCode.entity.TestMember;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class MemberRequestForm {
    String memberEmail;
    String memberName;
    String memberPassword;

    public TestMember toTestMember() {
        return new TestMember(memberEmail, memberName, memberPassword);
    }

    public MemberRequestForm(String memberEmail, String memberName, String memberPassword) {
        this.memberEmail = memberEmail;
        this.memberName = memberName;
        this.memberPassword = memberPassword;
    }
}
