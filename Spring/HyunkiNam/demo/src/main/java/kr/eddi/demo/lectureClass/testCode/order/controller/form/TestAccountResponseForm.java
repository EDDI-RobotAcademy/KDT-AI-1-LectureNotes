package kr.eddi.demo.lectureClass.testCode.order.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TestAccountResponseForm {
    final private Long accountId;
    private String email;

    public TestAccountResponseForm(Long accountId, String email) {
        this.accountId = accountId;
        this.email = email;
    }
}
