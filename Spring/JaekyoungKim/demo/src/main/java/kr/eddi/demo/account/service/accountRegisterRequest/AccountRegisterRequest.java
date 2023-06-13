package kr.eddi.demo.account.service.accountRegisterRequest;

import kr.eddi.demo.account.entity.MemberAccount;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountRegisterRequest {
    final private String email;

    public MemberAccount toAccount() {
        return new MemberAccount(email);
    }
}