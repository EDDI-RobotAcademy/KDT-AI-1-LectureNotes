package com.example.demo.lectureClass.testCode.order.service;

import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountResponseForm;
import com.example.demo.lectureClass.testCode.order.controller.form.TestOrderAccountRequestForm;
import com.example.demo.lectureClass.testCode.order.controller.form.TestOrderListRequestForm;
import com.example.demo.lectureClass.testCode.order.controller.form.TestOrderRequestForm;
import com.example.demo.lectureClass.testCode.order.entity.TestOrder;
import com.example.demo.lectureClass.testCode.product.controller.form.TestOrderProductResponseForm;

import java.util.List;

public interface TestOrderService {
    TestOrder order (TestOrderRequestForm requestForm, Long accountId);

    List<TestOrder> orderListForAccount(
            TestOrderListRequestForm orderListRequestForm, Long accountId);

    List<TestAccountResponseForm> findAllAccountWhoBuyProduct(TestOrderAccountRequestForm requestForm);
}
