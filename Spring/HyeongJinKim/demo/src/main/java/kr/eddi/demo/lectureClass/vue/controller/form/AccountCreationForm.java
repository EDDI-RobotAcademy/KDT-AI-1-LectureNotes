package kr.eddi.demo.lectureClass.vue.controller.form;

import kr.eddi.demo.lectureClass.vue.controller.form.gameCharacter.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class AccountCreationForm {
    final private String newEmail;
    final private String newPw;

    public Account toAccount(int accountId) {
        return new Account(accountId, newEmail, newPw);
    }
}