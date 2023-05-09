package kr.eddi.demo.lectureClass.testCode.problem.controller.form;


import kr.eddi.demo.lectureClass.testCode.problem.entity.Member1;

public class Member1RequestForm {
    String accountId;
    String password;
    public Member1 toMember() {
        return new Member1(accountId, password);
    }
}
