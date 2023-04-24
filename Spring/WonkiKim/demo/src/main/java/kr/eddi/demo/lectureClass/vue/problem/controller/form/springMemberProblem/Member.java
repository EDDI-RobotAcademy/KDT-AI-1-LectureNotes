package kr.eddi.demo.lectureClass.vue.problem.controller.form.springMemberProblem;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public class Member {
    static private int idGenerator = 1;
    final private int id;
    final private String email;
    final private String password;

    public Member(SignUpRequestForm signUpRequestForm) {
        this.id = idGenerator++;
        this.email = signUpRequestForm.getEmail();
        this.password = signUpRequestForm.getEmail();
    }
}
