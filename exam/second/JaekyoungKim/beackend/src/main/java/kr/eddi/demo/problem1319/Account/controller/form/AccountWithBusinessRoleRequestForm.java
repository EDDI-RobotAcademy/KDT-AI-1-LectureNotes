package kr.eddi.demo.problem1319.Account.controller.form;

import kr.eddi.demo.problem1319.Account.entity.Account;
import kr.eddi.demo.problem1319.Account.entity.BusinessAccountRole;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountWithBusinessRoleRequestForm {

    final private String email;
    final private String password;
    final private String role;
    final private Integer businessCode;

    public Account toAccount() {
        return new Account(email, password);
    }

    public BusinessAccountRole toAccountRole(Account account) {
        return new BusinessAccountRole(role, businessCode,account);
    }
}

