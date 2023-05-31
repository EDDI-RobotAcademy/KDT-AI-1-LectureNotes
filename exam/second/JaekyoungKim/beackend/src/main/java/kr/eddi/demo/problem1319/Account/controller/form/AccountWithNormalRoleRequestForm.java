package kr.eddi.demo.problem1319.Account.controller.form;

import kr.eddi.demo.problem1319.Account.entity.Account;
import kr.eddi.demo.problem1319.Account.entity.NormalAccountRole;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class AccountWithNormalRoleRequestForm {

    final private String email;
    final private String password;
    final private String role;

    public Account toAccount() {
        return new Account(email, password);
    }

    public NormalAccountRole toAccountRole(Account account) {
        return new NormalAccountRole(role, account);
    }
}