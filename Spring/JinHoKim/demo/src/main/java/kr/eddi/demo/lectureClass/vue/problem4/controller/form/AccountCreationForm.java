package kr.eddi.demo.lectureClass.vue.problem4.controller.form;


import kr.eddi.demo.lectureClass.vue.problem4.controller.entitiy.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class AccountCreationForm{

    final private String email;
    final private String password;

    public Account toAccount(Long accountId) {
        return new Account(accountId, email, password);
    }
}
