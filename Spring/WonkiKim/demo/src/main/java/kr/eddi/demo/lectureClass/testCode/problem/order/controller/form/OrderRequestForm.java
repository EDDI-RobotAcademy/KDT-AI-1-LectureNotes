package kr.eddi.demo.lectureClass.testCode.problem.order.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class OrderRequestForm {

    final private String userToken;
    @Getter
    final private Long productId;

}
