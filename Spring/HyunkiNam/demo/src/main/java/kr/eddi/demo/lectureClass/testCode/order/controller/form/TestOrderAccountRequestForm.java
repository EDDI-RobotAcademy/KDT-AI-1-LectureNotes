package kr.eddi.demo.lectureClass.testCode.order.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class TestOrderAccountRequestForm {

    final private Long productId;

    public TestOrderAccountRequestForm(Long productId) {
        this.productId = productId;
    }
}
