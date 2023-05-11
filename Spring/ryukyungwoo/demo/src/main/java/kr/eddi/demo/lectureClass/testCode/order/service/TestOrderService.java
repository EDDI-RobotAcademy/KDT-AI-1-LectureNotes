package kr.eddi.demo.lectureClass.testCode.order.service;

import kr.eddi.demo.lectureClass.testCode.order.controller.form.TestOrderRequestForm;
import kr.eddi.demo.lectureClass.testCode.order.entity.TestOrder;

public interface TestOrderService {
    TestOrder order (TestOrderRequestForm requestForm);
}