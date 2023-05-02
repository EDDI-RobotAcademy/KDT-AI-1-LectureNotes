package kr.eddi.demo.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class CharacterInfoForm {
    final private String user_email;
    final private String user_password;
}
