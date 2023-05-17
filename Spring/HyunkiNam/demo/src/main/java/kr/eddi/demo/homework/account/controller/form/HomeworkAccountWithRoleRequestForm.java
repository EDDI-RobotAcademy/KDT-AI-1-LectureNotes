package kr.eddi.demo.homework.account.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import kr.eddi.demo.homework.account.entity.HomeworkAccount;
import kr.eddi.demo.homework.account.entity.HomeworkAccountRole;
import kr.eddi.demo.homework.account.entity.HomeworkAccountRoleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
//@RequiredArgsConstructor
@NoArgsConstructor
public class HomeworkAccountWithRoleRequestForm {

    private String email;
    private String password;
    @JsonProperty("role")
    private HomeworkAccountRoleType accountRoleType;

    public HomeworkAccount toHomeworkAccount() {
        return new HomeworkAccount(email, password);
    }

    public HomeworkAccountWithRoleRequestForm(String email, String password, HomeworkAccountRoleType accountRoleType) {
        this.email = email;
        this.password = password;
        this.accountRoleType = accountRoleType;
    }
}