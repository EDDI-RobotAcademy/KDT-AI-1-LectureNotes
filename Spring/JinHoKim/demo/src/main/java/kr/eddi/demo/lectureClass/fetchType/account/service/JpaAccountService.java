package kr.eddi.demo.lectureClass.fetchType.account.service;

import kr.eddi.demo.lectureClass.fetchType.account.controller.form.JpaAccountResponseForm;
import kr.eddi.demo.lectureClass.fetchType.account.controller.form.JpaAccountWithRoleRequestForm;
import kr.eddi.demo.lectureClass.fetchType.account.entity.JpaAccount;
import kr.eddi.demo.lectureClass.testCode.account.controller.form.TestAccountWithRoleRequestForm;

import java.util.List;

public interface JpaAccountService {
    JpaAccount registerWithRole(JpaAccountWithRoleRequestForm requestForm);

    List<JpaAccountResponseForm> accountListWithRole(String role);
}
