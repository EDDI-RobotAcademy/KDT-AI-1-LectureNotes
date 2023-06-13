package kr.jinho.jinhokim.testCode.order.service;

import kr.jinho.jinhokim.testCode.order.controller.form.TestAccountResponseForm;
import kr.jinho.jinhokim.testCode.order.controller.form.TestOrderAccountRequestForm;
import kr.jinho.jinhokim.testCode.order.controller.form.TestOrderListRequestForm;
import kr.jinho.jinhokim.testCode.order.controller.form.TestOrderRequestForm;
import kr.jinho.jinhokim.testCode.order.entity.TestOrder;

import java.util.List;

public interface TestOrderService {
    TestOrder order(TestOrderRequestForm requestForm);

    List<TestOrder> orderListForAccount(TestOrderListRequestForm orderListRequestForm);

    List<TestAccountResponseForm> findAllAccountWhoBuyProduct(TestOrderAccountRequestForm requestForm);
}
