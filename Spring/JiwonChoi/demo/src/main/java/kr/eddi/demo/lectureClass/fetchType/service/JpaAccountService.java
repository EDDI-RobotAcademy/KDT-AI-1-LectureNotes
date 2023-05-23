package kr.eddi.demo.lectureClass.fetchType.service;

import kr.eddi.demo.lectureClass.fetchType.controller.form.JpaAccountResponseForm;
import kr.eddi.demo.lectureClass.fetchType.controller.form.JpaAccountWithRoleRequestForm;
import kr.eddi.demo.lectureClass.fetchType.entity.JpaAccount;

import java.util.List;

public interface JpaAccountService {
    JpaAccount registerWithRole(JpaAccountWithRoleRequestForm requestForm);
    List<JpaAccountResponseForm> accountListWithRole(String role);

}