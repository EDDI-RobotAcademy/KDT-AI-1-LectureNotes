package com.example.demo.orderTest;

import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountLoginResponseForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.service.TestAccountService;
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
    @DisplayName("회원이 상품을 주문합니다")
    void 회원이_상품을_주문합니다 () {
        final String email = "test2@test.com";
        final String password = "test2";
        final Long productId = 1L;
        final Long accountId = 1L;

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);

        String userToken = responseForm.getUserToken().toString();

        TestOrderRequestForm orderRequestForm = new TestOrderRequestForm(userToken, productId);
        TestOrder order = testOrderService.order(orderRequestForm);

        assertEquals(productId, order.getTestProduct().getId());
        assertEquals(accountId, order.getTestAccount().getId());
    }

    @Test
    @DisplayName("회원이 주문한 상품을 조회합니다.")
    void 회원이_주문한_상품을_조회합니다 () {
        final String email ="test@test.com";
        final String password ="test";
        final Long accountId = 1L;

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);

        String userToken = responseForm.getUserToken().toString();

        TestOrderListRequestForm orderListRequestForm = new TestOrderListRequestForm(userToken);
        List<TestOrder> orderListForAccount = testOrderService.orderListForAccount(orderListRequestForm);
        System.out.println("orderListForAccount size: " + orderListForAccount.size());

        for (TestOrder order: orderListForAccount) {
            assertEquals(accountId, order.getTestAccount().getId());
        }
    }

    @Test
    @DisplayName("특정 물품을 구매한 회원 리스트를 조회합니다.")
    void 특정_물품을_구매한_회원_정보_조회 () {
        final Long productId = 1L;

        // 이 상품을 구매한 사람을 가져오세요
        TestOrderAccountRequestForm requestForm = new TestOrderAccountRequestForm(productId);
        List<TestAccountResponseForm> accountResponseFormList = testOrderService.findAllAccountWhoBuyProduct(requestForm);
        // 필요한 부분만 가져올것이기 때문에 TestAccount 가 이닌 TestAccountResponseForm 새로 생성

        System.out.println("accountList size: " + accountResponseFormList.size());

        for (TestAccountResponseForm responseForm: accountResponseFormList) {
            assertTrue(responseForm.getAccountId() != null);
            // 사용자값이 null 이 아니면 됨
        }
    }
}