package kr.eddi.demo.lectureClass.testCode.problem.order.service;

import kr.eddi.demo.lectureClass.testCode.problem.order.controller.form.OrderListByMemberRequestForm;
import kr.eddi.demo.lectureClass.testCode.problem.order.controller.form.OrderListByProductRequestForm;
import kr.eddi.demo.lectureClass.testCode.problem.order.controller.form.OrderListResponseForm;
import kr.eddi.demo.lectureClass.testCode.problem.order.controller.form.OrderRequestForm;
import kr.eddi.demo.lectureClass.testCode.problem.order.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    public Long findMemberId(String userToken);
    public OrderEntity order(OrderRequestForm orderRequestForm);
    public OrderListResponseForm serchOrderListByMember(OrderListByMemberRequestForm orderListByMemberRequestForm);

    OrderListResponseForm serchOrderListByProduct(OrderListByProductRequestForm orderListByProductRequestForm);
}
