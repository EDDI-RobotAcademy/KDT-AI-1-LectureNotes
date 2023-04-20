package kr.eddi.demo.lectureClass.vue.controller.form;
import kr.eddi.demo.lectureClass.vue.controller.form.gameCharacter.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class AccountCreationForm {
    final private int id;
    final private int password;

    public Account toAccount(int accountId) {
        return new Account(accountId, id, password);
    }
}