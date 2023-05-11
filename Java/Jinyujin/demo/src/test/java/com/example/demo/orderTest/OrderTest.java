package com.example.demo.orderTest;

import com.example.demo.lectureClass.testCode.account.Service.TestAccountService;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountLoginResponseForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountResponseForm;
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
    // 테스트 자체가 백로그가 되는 것
    // -> 도메인 분리가 된다
    void 회원이_상품을_주문합니다() {
        // 아까 만들어둔 계정으로 로그인
        final String email = "test@test.com";
        final String password = "test";
        final Long productId = 1L;
        final Long accountId = 1L;
        // 지금은 이렇게 지정해뒀기 때문에 딱 이대로만 실행해야 test pass함
        // OrderTest는 등록 계속 시키면 계속 주문할 수 있음
        // 근데 accountId 1번이 productId 2번만 등록하는 만큼 사는 것으로 나타나는 것

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);

        String userToken = responseForm.getUserToken().toString(); // String 맞춰준 것

        TestOrderRequestForm orderRequestForm = new TestOrderRequestForm(userToken, productId);
        // 이제 오더리퀘스트폼이 필요
        // 상품 Id값이 필요하여 추가해줌
        // 얘는 상품이랑 토큰 정보 두 개 다 처리해야함
        // 그래서 사실상 orderService에서 order를 해줘야 하고
        // 주문이 들어갈꺼니까 리턴된 오더를 봐야함
        TestOrder order = testOrderService.order(orderRequestForm, accountId);  // 실제로 accountId 주면 안됨

        assertEquals(productId, order.getTestProduct().getId());
        assertEquals(accountId, order.getTestAccount().getId());
    }

    @Test
    @DisplayName("회원이 주문한 상품을 조회합니다")
    void 회원이_주문한_상품을_조회합니다 () {
        final String email = "test@test.com";
        final String password = "test";
        final Long accountId = 1L;
        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password);
        TestAccountLoginResponseForm responseForm = testAccountService.login(requestForm);
        String userToken = responseForm.getUserToken().toString();

        TestOrderListRequestForm orderListRequestForm = new TestOrderListRequestForm(userToken);
        List<TestOrder> orderListForAccount = testOrderService.orderListForAccount(orderListRequestForm, accountId);
        System.out.println("orderListForAccount size: " + orderListForAccount.size());

        for (TestOrder order: orderListForAccount) {
            assertEquals(accountId, order.getTestAccount().getId());
        }
    }
    /* “회원이 주문한 상품을 조회합니다”
        회원 이메일이랑 패스워드 작성하고
        폼이랑 유저토큰 그대로 가져옴
        ----- 여기까지는 주문한 회원에 대한 정보 가져오기 -----
        오더리퀘스트 폼을 작성함 - 요청한 상품 받아오기
        이걸 가지고 작업해야함
        오더서비스.orderListForAccount -> 계정에 대한 주문 리스트라는 것을 알 수 있음
        그리고 orderList를 받아오는데 이거는 어카운트에 관한 것이니까
        orderListForAccount라고 만들어도 됨
        asssertEquals(accountId)
        -> 리턴을 해도 되지만 지금은 리턴이 없으니까 이퀄스로 작성
        리스트는 foreach돌림
        그래서 테스트 오더 객체를 가진 오더리스트포어카운트에 있는 내역들을 하나씩 order에 담아줌
        그리고 내가 입력해둔 accountId가 order에 있는 아이디와 같냐
       (어카운트 아이디에는 아이디 나올 것이니까 위에 추가해주기
       1번 회원이 구매한 오더리스트를 쭉 볼 것)

       이제 테스트오더리퀘스트폼 가서 작성해주기
       테스트 오더 서비스와 임플에도 구색 맞춰주기

       작성하고 와서 sout 추가 -> 리스트 사이즈 확인
       -> 여기서는 log.info 쓰는게 안 맞는건가?
       ------------ 사용자 주문 내역 조회 완료 ------------
     */

    // 추가 구매 유도
    @Test
    @DisplayName("특정 물품을 구매한 회원 리스트를 조회합니다")
    void 특정_물품을_구매한_회원_정보_조회 () {
        final Long productId = 3L;
        // 특정 물품에는 그 물건의 productId가 필요할 것 = 1L
        // -> 이 상품을 구매한 사람들을 보려고 하는 것
        // 위에는 유저토큰을 넣는다는 느낌으로 진행한거고 이번에는 회원 등록, 로그인 절차 없이 해볼 것

        // 1. productId가 1인 상품을 받아오기
        TestOrderAccountRequestForm requestForm = new TestOrderAccountRequestForm(productId);
        // TestOrderAccountRequestForm 객체 생성해서 productId가 1인 값을 넣어줌
        // 여기로 요청한 상품이 productId가 1인 값인 것
        // 그걸 requestForm에 저장

        // 2. 그 상품을 구매한 회원들 찾아오기
        // 3. 리스트에 담아주기
        List<TestAccountResponseForm> accountResponseFormList =
                testOrderService.findAllAccountWhoBuyProduct(requestForm);
        /*
        // 그 사람들의 리스트를 받아오려고 함
        // TestAccountResponseForm 그럼 여기 안에는 뭐가 들어가야 할까?
        // 일단 TestAccount의 accountId가 필요할 듯 해보임
         */

        // requestForm의 값과 맞는 상품을 산 사람들의 리스트를 만들어줌
        // -> 이 상품을 구매한 사람을 가져오세요 하는 것

        // 여기서 List 형식이 뭐가 될지 정할 수 있어야 함
        // 쌤도 처음에는 TestAccount라고 했다가 responseForm으로 바꾸심
        // 왜?
        // 생각해야 할 것
        // 실질적으로 관리자 페이지 만든다고 해서 이 상품을 구매한 사람의 정보 줘 했을 때
        // 모든 정보를 가져와야 해? 아니면 필요한 정보만 가져와야 해? 후자
        // 그래서 사실상 List<TestAccount>에 TestAccount를 가져오면 언됨
        // TestAccountResponseForm을 만들어서 필요한 정보만 가져와야 함

        System.out.println("accountList.size: " + accountResponseFormList.size());

        // 4. 그 리스트에 있는 회원들의 아이디가 존재하는지 여부 판정하기
        for (TestAccountResponseForm responseForm: accountResponseFormList) {
            assertTrue(responseForm.getAccountId() != null);
            // 그래서 assertTrue로 가야겠다고 바꾸심
            // responseForm에 사용자 id값이 들어올꺼고 그게 null이 아니면 됨
            // -> 이걸 생각할 수도 있어야 할 듯 ㅠㅠ
            // 구현 꼭 해보자
        }
    }
}
