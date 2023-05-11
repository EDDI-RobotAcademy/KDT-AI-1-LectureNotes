package com.example.demo.lectureClass.testCode.order.service;

import com.example.demo.lectureClass.testCode.order.controller.form.TestAccountResponseForm;
import com.example.demo.lectureClass.testCode.order.controller.form.TestOrderAccountRequestForm;
import com.example.demo.lectureClass.testCode.order.controller.form.TestOrderListRequestForm;
import com.example.demo.lectureClass.testCode.order.controller.form.TestOrderRequestForm;
import com.example.demo.lectureClass.testCode.order.entity.TestOrder;

import java.util.List;

public interface TestOrderService {
    TestOrder order(TestOrderRequestForm orderRequestForm,Long accountId);

    List<TestOrder> orderListForAccount(TestOrderListRequestForm orderListRequestForm, Long accountId);

    List<TestAccountResponseForm> FindAllAccountWhoBuyProduct(TestOrderAccountRequestForm requestForm);
}
