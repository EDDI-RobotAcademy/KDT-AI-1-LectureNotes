package kr.eddi.demo.testCode.order.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestAccountResponseForm {

    private final Long accountId;
    final private String email;

}
