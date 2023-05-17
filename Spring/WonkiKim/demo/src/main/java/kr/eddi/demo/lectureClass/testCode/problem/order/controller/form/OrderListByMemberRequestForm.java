package kr.eddi.demo.lectureClass.testCode.problem.order.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderListByMemberRequestForm {
    @Getter
    final String userToken;
}
