package kr.eddi.demo.vue.problem.Controller.form;

import kr.eddi.demo.vue.problem.entity.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class AccountCreationForm {

    final private String email;
    final private String password;
    // 생성할때 받아오는 데이터 정보와 맞춰져야 한다.


    public Account toAccount(Long accountId) {
        return new Account(accountId, email, password);
    }
    //받아온 데이터로 어카운트 생성해주는 메서드 필요하다.
}