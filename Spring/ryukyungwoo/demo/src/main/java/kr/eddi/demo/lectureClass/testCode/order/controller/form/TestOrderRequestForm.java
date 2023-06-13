package kr.eddi.demo.lectureClass.testCode.order.controller.form;

import kr.eddi.demo.lectureClass.testCode.order.entity.TestOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestOrderRequestForm {
    final private String userToken;
    final private Long productId;
}
