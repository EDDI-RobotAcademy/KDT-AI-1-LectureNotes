package kr.eddi.demo.lectureClass.account.controller.form;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AccountResponseForm {

    final private String email;

    public AccountResponseForm(String email) {
        this.email = email;
    }
}