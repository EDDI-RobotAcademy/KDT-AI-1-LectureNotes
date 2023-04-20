package kr.eddi.demo.problem4;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class IdRequestForm {
    String email;
    String password;
}
