package com.example.demo.lectureClass.testCode.order.service;

import com.example.demo.lectureClass.testCode.order.controller.form.TestOrderRequestForm;
import com.example.demo.lectureClass.testCode.order.entity.TestOrder;

public interface TestOrderService {
    TestOrder order (TestOrderRequestForm requestForm);
}
