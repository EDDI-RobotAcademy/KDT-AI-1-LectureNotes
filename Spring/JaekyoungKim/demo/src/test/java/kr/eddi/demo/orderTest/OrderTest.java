package kr.eddi.demo.orderTest;

import kr.eddi.demo.testCode.order.controller.form.TestAccountResponseForm;
import kr.eddi.demo.testCode.account.controller.form.TestAccountLoginResponseForm;
import kr.eddi.demo.testCode.account.controller.form.TestAccountRequestForm;
import kr.eddi.demo.testCode.account.service.TestAccountService;
import kr.eddi.demo.testCode.order.controller.form.TestOrderAccountRequestForm;
import kr.eddi.demo.testCode.order.controller.form.TestOrderListRequestForm;
import kr.eddi.demo.testCode.order.controller.form.TestOrderRequestForm;
import kr.eddi.demo.testCode.order.entity.TestOrder;
import kr.eddi.demo.testCode.order.service.TestOrderService;
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
        final String email = "test@test.com";
        final String password = "test";
        final Long productId = 1L;
        final Long accountId = 1L;
        // 우선 회원인지 먼저 검증한다.
        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        // 리퀘스트 폼을 리스폰스 로그인에 넣어서 로그인 간으한지 체크한다.
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);
        // 로그인이 되면 유저 토큰 가져온다.

        String userToken = responseForm.getUserToken().toString();
        // 유저 토큰을 가져옴
        TestOrderRequestForm orderRequestForm = new TestOrderRequestForm(userToken, productId);
        //유저 토큰과 프로덕트 id로 구매 폼을 만든다.
        TestOrder order = testOrderService.order(orderRequestForm,accountId);
        // 구매 폼과 accountId를 넣어서 테스트 오더의 서비스 진행한다.

        assertEquals(productId, order.getTestProduct().getId());
        assertEquals(accountId, order.getTestAccount().getId());
    }
    @Test
    @DisplayName("회원이 주문한 상품을 조회합니다")
    void 회원이_주문한_상품을_조회합니다 () {
        final String email = "gogo@gogo.com";
        final String password = "gogo";
        final Long accountId = 1L;

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        // 정보를 넣고 해당 정보들이 래포지토리에 존재 하는지 검색한다.
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);
        //로그인 폼에서 받은 유저 토큰을 스트링화 해서 넣는다.
        String userToken = responseForm.getUserToken().toString();

        TestOrderListRequestForm orderListRequestForm = new TestOrderListRequestForm(userToken);
        // 유저 토큰을 OrderListRequestForm에 넣는다.
        List<TestOrder> orderListForAccount = testOrderService.orderListForAccount(orderListRequestForm,accountId);
        // 주문한 리스트를 가져온다.
        System.out.println("orderListForAccount size: " + orderListForAccount.size());
        //주문 갯수를 표현해주는 부분

        for (TestOrder order: orderListForAccount) {
            // 리스트의 오더 갯수만큼 반복하겠다.
            System.out.println("구매한 상품: "+order.getTestProduct().getProductName());
            // 위에가져온 accountId와 리스트로 뽑아온 주문의 어카운트의 아이디가 같은지 검증한다.
            assertEquals(accountId, order.getTestAccount().getId());
        }
    }
    @Test
    @DisplayName("특정 물품을 구매한 회원 리스트를 조회합니다.")
    void 특정_물품을_구매한_회원_정보_조회 () {
        final Long productId=1L;
        // 데이터를 리퀘스트 폼에 넣어준다.
        // 리퀘스트폼을 생성한다.
        TestOrderAccountRequestForm requestForm= new TestOrderAccountRequestForm(productId);
        //조회 이기때문에 리스트 형식으로 할 것이다.
        // 주문 한 사람의 어카운트id 와 이메일 뽑 아올것이다.
        List<TestAccountResponseForm> accountResponseFormList = testOrderService.findAllAccountWhoBuyProduct(requestForm);
        // 서비스의 메서드에 프로덕트 id 넣어준다.
        System.out.println("accountList size: "+accountResponseFormList.size());
        // 주문 내역의 갯수
        System.out.println("account eamil: "+accountResponseFormList.get(0).getEmail());
        //가져온 리스트 만큼 반복한다. 무엇을? 리스폰스 폼이 비어있지 않음을 증명한다.

        for (TestAccountResponseForm responseForm:accountResponseFormList) {
            assertTrue(responseForm.getAccountId()!=null);
        }
        }
    }

