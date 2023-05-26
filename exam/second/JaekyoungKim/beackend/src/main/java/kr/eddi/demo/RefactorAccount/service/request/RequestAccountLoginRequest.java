package kr.eddi.demo.RefactorAccount.service.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RequestAccountLoginRequest {
    final private String email;
    final private String password;
}
