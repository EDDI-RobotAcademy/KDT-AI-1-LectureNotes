package kr.eddi.demo.lectureClass.refactorAccount.controller.form;

import kr.eddi.demo.lectureClass.refactorAccount.entity.RoleType;
import kr.eddi.demo.lectureClass.refactorAccount.service.request.RefactorAccountRegisterRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class RefactorAccountRegisterRequestForm {

    final private String email;
    final private String password;
    final private RoleType roleType;

    public RefactorAccountRegisterRequest toRefactorAccountRegisterRequest () {

        return new RefactorAccountRegisterRequest(
                email, password, roleType);
    }
}
