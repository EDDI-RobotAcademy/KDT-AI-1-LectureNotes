package kr.eddi.demo.lectureClass.testCode.account.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class TestAccountLoginResponseForm {

    final private UUID userToken;
}
