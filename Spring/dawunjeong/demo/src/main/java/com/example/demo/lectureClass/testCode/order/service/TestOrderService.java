package com.example.demo.lectureClass.testCode.order.service;

import com.example.demo.lectureClass.testCode.order.controller.form.TestAccountResponseForm;
import com.example.demo.lectureClass.testCode.order.controller.form.TestOrderAccountRequestForm;
import com.example.demo.lectureClass.testCode.order.controller.form.TestOrderListRequestForm;
import com.example.demo.lectureClass.testCode.order.controller.form.TestOrderRequestForm;
import com.example.demo.lectureClass.testCode.order.entity.TestOrder;

import java.util.List;

public interface TestOrderService {

    TestOrder order (TestOrderRequestForm requestForm, Long accountId);

    List<TestOrder> orderListForAccount(TestOrderListRequestForm orderListRequestForm, Long accountId);

    // 특정 상품을 구매한 회원 찾기(정다운)
    List<TestOrder> findAllOrderWhoBuyProduct(TestOrderAccountRequestForm orderAccountRequestForm);

    // 특정 상품을 구매한 회원 찾기(선생님 풀이)
    List<TestAccountResponseForm> findAllAccountWhoBuyProduct(TestOrderAccountRequestForm requestForm);
}
