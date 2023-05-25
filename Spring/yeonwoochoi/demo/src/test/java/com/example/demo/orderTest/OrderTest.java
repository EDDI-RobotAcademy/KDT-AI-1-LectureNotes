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
    // 주문을 할 때 Request와 Response 어떤것이 사용되는지 생각해보자
    // 주문을 할때에는 Request만 사용 했다.
    @DisplayName("회원이 상품을 주문합니다")
    void 회원이_상품을_주문합니다() {
        final String email = "test@test.com";
        final String password = "test";
        final Long productId = 1L;
        final Long accountId = 1L;

        // Request 요청
        // Response 응답

        // 페이지를 들어가면 로그인을 먼저 한다.
        // 정보를 프론트에서 폼으로 받아옴 (email, password)에 정보를 객체로 생성해서 requestForm에 대입
        // requestForm = email, password
        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        // 서비스에서 로그인 기능을 하고 email, password 정보로 로그인하고, 그 값을 responseForm에 대입
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);

        // userToken - 로그인 상태에서 누군지 알려주는 식별 형태, 보안성
        // 로그인 상태(responseForm)가 되고, 로그인이 되면(getUserToken()) UserToken을
        // 문자열(toString()) 형태로 가져온다.
        // 결과값을 userToken에 대입한다.
        String userToken = responseForm.getUserToken().toString();

        // 상품 정보, 토큰 정보 두가지 모두 처리 해야함
        // userToken 가지고 있는 사용자가 productId 상품을 주문 한다.
        // 주문한 상품 정보를 폼으로 받아오고, userToken, productId 정보를 객체로 만들어준다.
        // orderRequestForm에 대입 한다.
        TestOrderRequestForm orderRequestForm = new TestOrderRequestForm(userToken, productId);
        // 실제로 accountId 주면 안된다. (지금은 매번 바꿔야 해서 혼선이 생기므로 준 상태)
        // 지금은 accountId가 내 계정이라고 생각하면 된다.
        // Service에서 주문한 userToken, productId(orderRequestForm)와 accountId 값을 order 대입 한다.
        TestOrder order = testOrderService.order(orderRequestForm, accountId);

        // 내가 고른 productId, 주문한 상품의 Id가 같으면 성공(Equals)
        // 나의 계정 accountId, 주문한 상품 계정Id가 같으면 성공(Equals)
        assertEquals(productId, order.getTestProduct().getId());
        assertEquals(accountId, order.getTestAccount().getId());
    }

    @Test
    @DisplayName("회원이 주문한 상품을 조회합니다")
    void 회원이_주문한_상품을_조회합니다() {
        final String email = "test@test.com";
        final String password = "test";
        final Long accountId = 2L;

        // Request 요청
        // Response 응답

        // 로그인하면 동작하는 코드
        // 회원 정보를 폼으로 받아서 객체를 만듬
        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        // 서비스에서 로그인 기능을 하고 email, password 정보로 로그인하고, 그 값을 responseForm에 대입
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);
        // userToken - 로그인 상태에서 누군지 알려주는 식별 형태, 보안성
        // 로그인 상태(responseForm)가 되고, 로그인이 되면(getUserToken()) UserToken을
        // 문자열(toString()) 형태로 가져온다.
        // 결과값을 userToken에 대입한다.
        String userToken = responseForm.getUserToken().toString();

        // 주문 상품을 폼으로 받아서 userToken 정보를 객체로 만듬
        TestOrderListRequestForm orderListRequestForm = new TestOrderListRequestForm(userToken);
        // 서비스에서 회원이 주문한 상품 userToken, accountId
        List<TestOrder> orderListForAccount = testOrderService.orderListForAccount(orderListRequestForm, accountId);

        System.out.println("orderListForAccount size: " + orderListForAccount.size());

        // 상품을 리스트 형태로 뽑아줌
        //             상품      상품들
        for (TestOrder order : orderListForAccount) {
            //Equals(A, B) 일 때, A와 B가 같아야 테스트가 통과 ! 다르면 실패 !
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
            //True 조건의 결과값이 true여야 성공
            assertTrue(responseForm.getAccountId() != null);
        }
    }
}
