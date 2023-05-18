package kr.eddi.demo.vue.problem.Controller.form;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class LoginResponseForm {
    // 다시 뷰로 전달할 폼이다.
    final private Boolean isSuccessForLogin;
    final private Long gameAccountId;
}