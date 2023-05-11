package kr.eddi.demo.lectureClass.testCode.problem.order.service;

import kr.eddi.demo.lectureClass.testCode.problem.order.controller.form.OrderRequestForm;
import kr.eddi.demo.lectureClass.testCode.problem.order.entity.OrderEntity;

public interface OrderService {
    public Long findMemberId(String userToken);
    public OrderEntity order(OrderRequestForm orderRequestForm);
}
