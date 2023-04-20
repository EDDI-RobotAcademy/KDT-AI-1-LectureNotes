package kr.eddi.demo.problem4;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class LoginRequestForm {
    Integer id;
    String password;

}
