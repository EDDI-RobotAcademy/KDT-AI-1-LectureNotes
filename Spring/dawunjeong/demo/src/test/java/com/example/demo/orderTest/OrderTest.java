package com.example.demo.orderTest;

import com.example.demo.lectureClass.testCode.account.controller.form.account.TestAccountLoginResponseForm;
import com.example.demo.lectureClass.testCode.account.controller.form.account.TestAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.service.account.TestAccountService;
import com.example.demo.lectureClass.testCode.order.controller.form.TestAccountResponseForm;
import com.example.demo.lectureClass.testCode.order.controller.form.TestOrderAccountRequestForm;
import com.example.demo.lectureClass.testCode.order.controller.form.TestOrderListRequestForm;
import com.example.demo.lectureClass.testCode.order.controller.form.TestOrderRequestForm;
import com.example.demo.lectureClass.testCode.order.entity.TestOrder;
import com.example.demo.lectureClass.testCode.order.service.TestOrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class OrderTest {
    @Autowired
    private TestAccountService testAccountService;

    @Autowired
    private TestOrderService testOrderService;

    // 회원 Domain
    // 상품 Domain
    // 주문 Domain
    @Test
    @DisplayName("회원이 상품을 주문합니다!")
    void 회원이_상품을_주문합니다() {
        final String email = "consumer1@test.com";
        final String password = "consumer1";
        final Long productId = 2L;
        final Long accountId = 1L;

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseform = testAccountService.login(requestForm);

        String userToken = responseform.getUserToken().toString();

        TestOrderRequestForm orderRequestForm = new TestOrderRequestForm(userToken, productId);
        TestOrder order = testOrderService.order(orderRequestForm, accountId);

        assertEquals(productId, order.getTestProduct().getId());
        assertEquals(accountId, order.getTestAccount().getId());
    }

    @Test
    @DisplayName("회원이 주문한 상품을 조회합니다")
    void 회원이_주문한_상품을_조회합니다() {
        final String email = "consumer2@test.com";
        final String password = "consumer2";
        final Long accountId = 1L;

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseform = testAccountService.login(requestForm);

        String userToken = responseform.getUserToken().toString();

        TestOrderListRequestForm orderListRequestForm = new TestOrderListRequestForm(userToken);
        List<TestOrder> orderListForAccount = testOrderService.orderListForAccount(orderListRequestForm, accountId);
        System.out.println("orderListForAccount size: " + orderListForAccount.size());

        for(TestOrder order: orderListForAccount) {
            assertEquals(accountId, order.getTestAccount().getId());
        }
    }

    @Test
    @DisplayName("특정 물품을 구매한 회원 리스트를 조회합니다(정다운)")
    void 특정_물품을_구매한_회원_정보_조회_정다운_풀이() {
        final Long productId = 1L;

        TestOrderAccountRequestForm orderAccountRequestForm = new TestOrderAccountRequestForm(productId);
        List<TestOrder> orderListFindByProductId
                = testOrderService.findAllOrderWhoBuyProduct(orderAccountRequestForm);
        System.out.println("orderListFindByProductId size: " + orderListFindByProductId.size());

        for(TestOrder order: orderListFindByProductId) {
            assertTrue(order.getTestAccount().getId() != null);
            System.out.println(order.getTestAccount().getId());
        }
    }
    @Test
    @DisplayName("특정 물품을 구매한 회원 리스트를 조회합니다(선생님)")
    void 특정_물품을_구매한_회원_정보_조회_선생님_풀이() {
        final Long productId = 2L;

        TestOrderAccountRequestForm requestForm = new TestOrderAccountRequestForm(productId);
        List<TestAccountResponseForm> accountResponseFormList =
                testOrderService.findAllAccountWhoBuyProduct(requestForm);

        System.out.println("accountList size: " + accountResponseFormList.size());

        for (TestAccountResponseForm responseForm: accountResponseFormList) {
            System.out.println("account email: " + responseForm.getEmail());
            assertTrue(responseForm.getAccountId() != null);
        }
    }
}
