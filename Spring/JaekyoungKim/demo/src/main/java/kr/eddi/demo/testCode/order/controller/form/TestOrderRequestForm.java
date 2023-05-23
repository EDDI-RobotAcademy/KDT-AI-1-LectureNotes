package kr.eddi.demo.testCode.order.controller.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class TestOrderRequestForm {
    final private String userToken;
    final private Long productId;
}