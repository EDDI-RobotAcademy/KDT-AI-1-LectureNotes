package kr.eddi.demo.lectureClass.testCode.problem.order.controller.form;

import kr.eddi.demo.lectureClass.testCode.problem.order.entity.OrderEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class OrderListResponseForm {
    @Getter
    final List<OrderEntity> orderList;
}
