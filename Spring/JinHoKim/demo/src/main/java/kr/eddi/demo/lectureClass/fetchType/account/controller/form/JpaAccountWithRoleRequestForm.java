package kr.eddi.demo.lectureClass.fetchType.account.controller.form;

import kr.eddi.demo.lectureClass.fetchType.account.entity.JpaAccount;
import kr.eddi.demo.lectureClass.fetchType.account.entity.JpaAccountRole;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class JpaAccountWithRoleRequestForm {

    final private String email;
    final private String password;
    final private String role;

    public JpaAccount toJpaAccount() {
        return new JpaAccount(email, password);
    }

    public JpaAccountRole toJpaAccountRole(JpaAccount account) {
        return new JpaAccountRole(role, account);
    }
}
