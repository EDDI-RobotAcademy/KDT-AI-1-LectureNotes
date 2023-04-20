package kr.eddi.demo.problem4;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class AccountRequestForm {
    String email;
    String password;
}
