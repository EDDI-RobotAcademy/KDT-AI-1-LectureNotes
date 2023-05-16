package com.example.demo.lectureClass.order.service;

import com.example.demo.lectureClass.order.controller.form.TestOrderRequestForm;
import com.example.demo.lectureClass.order.entity.TestOrder;

public interface TestOrderService {

    TestOrder order (TestOrderRequestForm requestForm);
}
