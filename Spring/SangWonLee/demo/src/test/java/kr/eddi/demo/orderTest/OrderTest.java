package kr.eddi.demo.orderTest;

import kr.eddi.demo.lectureClass.testCode.account.controller.form.TestAccountLoginResponseForm;
import kr.eddi.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm;
import kr.eddi.demo.lectureClass.testCode.account.service.TestAccountService;
import kr.eddi.demo.lectureClass.testCode.order.controller.form.TestAccountResponseForm;
import kr.eddi.demo.lectureClass.testCode.order.controller.form.TestOrderAccountRequestForm;
import kr.eddi.demo.lectureClass.testCode.order.controller.form.TestOrderListRequestForm;
import kr.eddi.demo.lectureClass.testCode.order.controller.form.TestOrderRequestForm;
import kr.eddi.demo.lectureClass.testCode.order.entity.TestOrder;
import kr.eddi.demo.lectureClass.testCode.order.service.TestOrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderTest {
    @Autowired // 객체화 한다고 생각하면 된다.
    private TestAccountService testAccountService;

    @Autowired
    private TestOrderService testOrderService;

    // 회원 Domain
    // 상품 Domain
    // 주문 Domain
    @Test
    @DisplayName("회원이 상품을 주문합니다")
    void 회원이_상품을_주문합니다 () {
        final String email = "test@test.com";
        final String password = "test";
        final Long productId = 1L;
        final Long accountId = 1L;

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);
        // 받은 email과 password로 로그인한다. (아이디 비번이 다르면 테스트 실패임)

        String userToken = responseForm.getUserToken().toString();
        // userToken을 받아온다.
        System.out.println(userToken);
        // 궁금해서 확인



        TestOrderRequestForm orderRequestForm = new TestOrderRequestForm(userToken, productId);
        TestOrder order = testOrderService.order(orderRequestForm, accountId); // 실제로 accountId 주면 안됨
        // userTocken과 productId를 가지고 주문 저장

        assertEquals(productId, order.getTestProduct().getId());
        assertEquals(accountId, order.getTestAccount().getId());
        // 호출된 email, password가 입력한 값과 일치하는지 확인

    }

    @Test
    @DisplayName("회원이 주문한 상품을 조회합니다")
    void 회원이_주문한_상품을_조회합니다 () {
        final String email = "test@test.com";
        final String password = "test";
        final Long accountId = 1L;

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        // 받은 email, password로 TestAccountRequestForm 객체를 만든다.
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);
        // 로그인을 시도해서 나온 TestAccountLoginResponseForm 객체 값 (UUID임)을
        // responseForm에 저장한다.

        String userToken = responseForm.getUserToken().toString();
        // 받아온 UUID userToken을 String 화 시킨다.

        TestOrderListRequestForm orderListRequestForm = new TestOrderListRequestForm(userToken);
        // 받은 UUID로 TestOrderListRequestForm 객체를 만든다.

        List<TestOrder> orderListForAccount = testOrderService.orderListForAccount(orderListRequestForm, accountId);
        // orderListRequestForm, accountId를 인자로 orderListForAccount 메소드 실행


        System.out.println("orderListForAccount size: " + orderListForAccount.size());


        for (TestOrder order: orderListForAccount) {
            assertEquals(accountId, order.getTestAccount().getId());
        }
    }

    @Test
    @DisplayName("특정 물품을 구매한 회원 리스트를 조회합니다")
    void 특정_물품을_구매한_회원_정보_조회 () {
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