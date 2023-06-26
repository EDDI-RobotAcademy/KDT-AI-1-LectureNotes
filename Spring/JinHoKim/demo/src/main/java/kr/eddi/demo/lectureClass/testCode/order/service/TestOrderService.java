package kr.eddi.demo.lectureClass.testCode.order.service;

import kr.eddi.demo.lectureClass.testCode.order.controller.form.TestAccountResponseForm;
import kr.eddi.demo.lectureClass.testCode.order.controller.form.TestOrderAccountRequestForm;
import kr.eddi.demo.lectureClass.testCode.order.controller.form.TestOrderListRequestForm;
import kr.eddi.demo.lectureClass.testCode.order.controller.form.TestOrderRequestForm;
import kr.eddi.demo.lectureClass.testCode.order.entity.TestOrder;

import java.util.List;

public interface TestOrderService {
    TestOrder order (TestOrderRequestForm requestForm, Long accountId);

    List<TestOrder> orderListForAccount(
            TestOrderListRequestForm orderListRequestForm, Long accountId);

    List<TestAccountResponseForm> findAllAccountWhoBuyProduct(TestOrderAccountRequestForm requestForm);
}
