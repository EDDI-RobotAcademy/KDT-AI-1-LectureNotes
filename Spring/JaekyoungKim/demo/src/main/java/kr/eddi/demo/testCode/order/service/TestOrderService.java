package kr.eddi.demo.testCode.order.service;

import kr.eddi.demo.testCode.order.controller.form.TestOrderRequestForm;
import kr.eddi.demo.testCode.order.entity.TestOrder;


public interface TestOrderService {
    TestOrder order (TestOrderRequestForm requestForm);
}