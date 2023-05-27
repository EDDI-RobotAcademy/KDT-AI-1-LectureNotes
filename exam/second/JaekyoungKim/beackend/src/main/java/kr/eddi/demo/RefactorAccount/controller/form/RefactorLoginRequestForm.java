package kr.eddi.demo.RefactorAccount.controller.form;

import kr.eddi.demo.RefactorAccount.service.request.RequestAccountLoginRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RefactorLoginRequestForm {
    final private String email;
    final private String password;

    public RequestAccountLoginRequest toAccountLoginRequest () {

        return new RequestAccountLoginRequest(email, password);
    }
}
