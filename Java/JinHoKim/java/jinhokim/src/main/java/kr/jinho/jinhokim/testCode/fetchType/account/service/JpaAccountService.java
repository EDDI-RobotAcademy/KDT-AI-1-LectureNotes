package kr.jinho.jinhokim.testCode.fetchType.account.service;

import kr.jinho.jinhokim.testCode.fetchType.account.controller.form.JpaAccountResponseForm;
import kr.jinho.jinhokim.testCode.fetchType.account.controller.form.JpaAccountWithRoleRequestForm;
import kr.jinho.jinhokim.testCode.fetchType.account.entity.JpaAccount;

import java.util.List;

public interface JpaAccountService {

    JpaAccount registerWithRole(JpaAccountWithRoleRequestForm requestForm);

    List<JpaAccountResponseForm> accountListWithRole(String role);
}
