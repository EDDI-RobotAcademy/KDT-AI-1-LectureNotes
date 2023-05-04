package kr.eddi.demo.vue.problem.Controller.form;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class LoginResponseForm {
    final private Boolean isSuccessForLogin;
    final private Long gameAccountId;
}