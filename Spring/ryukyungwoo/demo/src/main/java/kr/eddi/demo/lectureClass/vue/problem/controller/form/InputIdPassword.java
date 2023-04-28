package kr.eddi.demo.lectureClass.vue.problem.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class InputIdPassword {
    private String email;
    private String password;
    public void InputIdPassword (String email, String password) {
        this.email = email;
        this.password = password;
    }
}
