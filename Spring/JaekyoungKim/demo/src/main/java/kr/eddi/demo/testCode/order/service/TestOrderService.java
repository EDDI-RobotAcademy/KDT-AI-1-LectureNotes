package kr.eddi.demo.testCode.order.service;

import kr.eddi.demo.testCode.order.controller.form.TestAccountListResponseForm;
import kr.eddi.demo.testCode.order.controller.form.TestOrderAccountRequestForm;
import kr.eddi.demo.testCode.order.controller.form.TestOrderListRequestForm;
import kr.eddi.demo.testCode.order.controller.form.TestOrderRequestForm;
import kr.eddi.demo.testCode.order.entity.TestOrder;

import java.util.List;


public interface TestOrderService {
    TestOrder order (TestOrderRequestForm requestForm);


    List<TestOrder> orderListForAccount(TestOrderListRequestForm orderListRequestForm);

    List<TestAccountListResponseForm> findAllAccountWhoBuyProduct(TestOrderAccountRequestForm requestForm);
}