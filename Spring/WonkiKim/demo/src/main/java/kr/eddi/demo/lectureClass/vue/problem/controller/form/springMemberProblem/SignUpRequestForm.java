package kr.eddi.demo.lectureClass.vue.problem.controller.form.springMemberProblem;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.RequestMapping;

@Getter
@ToString
@RequiredArgsConstructor
public class SignUpRequestForm {
    final private String email;
    final private String password;
}
