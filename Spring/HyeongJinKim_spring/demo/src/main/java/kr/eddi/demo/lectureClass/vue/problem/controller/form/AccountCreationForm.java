package kr.eddi.demo.lectureClass.vue.problem.controller.form;

import kr.eddi.demo.lectureClass.vue.problem.entity.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class AccountCreationForm {
    final private String newEmail;
    final private String newPw;

    public Account toAccount(int myAccountId) {
        return new Account(myAccountId, newEmail, newPw);
    }
}