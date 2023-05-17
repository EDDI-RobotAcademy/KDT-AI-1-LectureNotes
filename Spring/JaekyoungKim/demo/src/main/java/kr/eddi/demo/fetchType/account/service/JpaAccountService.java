package kr.eddi.demo.fetchType.account.service;

import kr.eddi.demo.fetchType.account.controller.form.JpaAccountResponseForm;
import kr.eddi.demo.fetchType.account.controller.form.JpaAccountWithRoleRequestForm;
import kr.eddi.demo.fetchType.account.entity.JpaAccount;
import kr.eddi.demo.testCode.account.controller.form.TestAccountWithRoleRequestForm;

import java.util.List;


public interface JpaAccountService {
    JpaAccount registerWithRole(JpaAccountWithRoleRequestForm requestForm);

    List<JpaAccountResponseForm> accountListWithRole(String role);
}