package kr.eddi.demo.lectureTest.problem;

import kr.eddi.demo.lectureClass.testCode.problem.order.controller.form.OrderRequestForm;
import kr.eddi.demo.lectureClass.testCode.problem.order.entity.OrderEntity;
import kr.eddi.demo.lectureClass.testCode.problem.order.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrderTest {
    @Autowired
    OrderService orderService;
    @Test
    @DisplayName("회원이 상품을 주문한다")
    void 회원이_상품을_주문한다() {
        String userToken = String.valueOf(UUID.randomUUID());
        Long productId = 1L;
        OrderRequestForm orderRequestForm = new OrderRequestForm(userToken, productId);
        OrderEntity order = orderService.order(orderRequestForm);

        assertEquals(productId, order.getProduct().getId());

    }
}
