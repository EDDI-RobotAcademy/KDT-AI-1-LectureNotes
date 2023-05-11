package com.example.demo.orderTest;

import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountLoginResponseForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import com.example.demo.lectureClass.testCode.order.controller.form.TestAccountResponseForm;
import com.example.demo.lectureClass.testCode.order.controller.form.TestOrderAccountRequestForm;
import com.example.demo.lectureClass.testCode.order.controller.form.TestOrderListRequestForm;
import com.example.demo.lectureClass.testCode.account.service.TestAccountService;
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

    // 회원이 상품을 주문한다는 시점.
    // 회원 Domain
    // 상품 Domain
    // 주문 Domain
    @Test
    @DisplayName("회원이 상품을 주문합니다")
    void 회원이_상품을_주문합니다() {
        final String email = "test@test.com";
        final String password = "test";
        final Long productId = 2L;
        final Long accountId = 2L;

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);

        String userToken = responseForm.getUserToken().toString();

        // 상품 정보, 토큰 정보 두가지 모두 처리 해야함
        // userToken 가지고 있는 사용자가 productId 상품을 주문 한다.
        TestOrderRequestForm orderRequestForm = new TestOrderRequestForm(userToken, productId);
        TestOrder order = testOrderService.order(orderRequestForm);

        assertEquals(productId, order.getTestProduct().getId());
        assertEquals(accountId, order.getTestAccount().getId());
    }

    @Test
    @DisplayName("회원이 주문한 상품을 조회합니다")
    void 회원이_주문한_상품을_조회합니다() {
        final String email = "test@test.com";
        final String password = "test";
        final Long accountId = 1L;

        // 로그인하면 동작하는 코드
        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);
        String userToken = responseForm.getUserToken().toString();

        TestOrderListRequestForm orderListRequestForm = new TestOrderListRequestForm(userToken);
        List<TestOrder> orderListForAccount = testOrderService.orderListForAccount(orderListRequestForm);
        System.out.println("orderListForAccount size: " + orderListForAccount.size());

        for (TestOrder order : orderListForAccount) {
            assertEquals(accountId, order.getTestAccount().getId());
        }
    }

    // 이벤트로 추가 구매 유도 하는 전략
    // 관리자가 조회하는 것
    // 특정 물품에 ProductId를 가지고 있음
    @Test // Test 자체가 하나의 백로그
    @DisplayName("특정 물품을 구매한 회원 리스트를 조회합니다")
    void 특정물품을_구매한_회원_정보_조회() {
        final Long productId = 2L;

        // 관리자 페이지 만들때 최소한의 필요한거만 보이면 된다.
        // TestAccount 전체를 가져오면 안된다.
        // TestAccountListResponseForm에 대한것만 가져오면 된다.
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
