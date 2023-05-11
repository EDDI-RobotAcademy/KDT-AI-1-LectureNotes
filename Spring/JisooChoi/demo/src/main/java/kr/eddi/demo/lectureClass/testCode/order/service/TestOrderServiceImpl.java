package kr.eddi.demo.lectureClass.testCode.order.service;

import kr.eddi.demo.lectureClass.testCode.account.controller.form.TestAccountResponseForm;
import kr.eddi.demo.lectureClass.testCode.account.controller.form.TestOrderAccountRequestForm;
import kr.eddi.demo.lectureClass.testCode.account.entity.TestAccount;
import kr.eddi.demo.lectureClass.testCode.account.repository.TestAccountRepository;
import kr.eddi.demo.lectureClass.testCode.order.controller.form.TestOrderListRequestForm;
import kr.eddi.demo.lectureClass.testCode.order.controller.form.TestOrderRequestForm;
import kr.eddi.demo.lectureClass.testCode.order.entity.TestOrder;
import kr.eddi.demo.lectureClass.testCode.order.repository.TestOrderRepository;
import kr.eddi.demo.lectureClass.testCode.product.entity.TestProduct;
import kr.eddi.demo.lectureClass.testCode.product.repository.TestProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestOrderServiceImpl implements TestOrderService {
    final private TestAccountRepository accountRepository;
    final private TestProductRepository productRepository;
    final private TestOrderRepository orderRepository;

    // 지금 redis를 쓸 수 없으므로 임시 방편용
    private Long alwaysReturnFirst (String userToken, Long accountId) {
        return accountId;
    }

    @Override
        public TestOrder order(TestOrderRequestForm requestForm, Long accountId) {
            final TestAccount account = isValidateAccount(
                    alwaysReturnFirst(requestForm.getUserToken(), accountId));

            if (account == null) return null;

            final Optional<TestProduct> maybeProduct =
                    productRepository.findById(requestForm.getProductId());
            if (maybeProduct.isEmpty()) {
                log.debug("주문을 진행할 수 없습니다!");
                return null;
            }
            final TestProduct product = maybeProduct.get();
            return orderRepository.save(new TestOrder(account, product));
        }

    @Override
    public List<TestOrder> orderListForAccount(
            TestOrderListRequestForm orderListRequestForm, Long accountId) {
        final TestAccount account = isValidateAccount(
                alwaysReturnFirst(orderListRequestForm.getUserToken(), accountId));

        if (account == null) return null;

        return orderRepository.findAllByAccountId(account.getId());
    }

    private TestAccount isValidateAccount(Long accountId) {
        final Optional<TestAccount> maybeAccount = accountRepository.findById(accountId);

        if (maybeAccount.isEmpty()) {
            log.debug("주문을 진행할 수 없습니다!");
            return null;
        }
        return maybeAccount.get();
    }

    @Override
    public List<TestAccountResponseForm> findAllAccountWhoBuyProduct(
            TestOrderAccountRequestForm requestForm){

        List<TestOrder> orderList =
                orderRepository.findAllAccountWhoByProduct(requestForm.getProductId());
        /*
            orderList 에는 accountId 가 들어있을 것이다.
            accountId만 따로 추출이 필요
            ?? 없는디 ..
            TestOrder라서 testAccount와 testProduct 두개를 가지고 있어서 그런가 ??
            ㅇㅇ "고객"이 "상품"을 "주문"했기 때문에 그렇다 !
            그리고 데이터 타입을 보면 TestOrder 인 것을 알 수 있듯 유추가능 ~
        */

        // 리턴할 값으로 하나 생성해주었다.
        List<TestAccountResponseForm> responseFormList = new ArrayList<>();

        for(TestOrder order: orderList){
            // 구매된 상품 리스트 속에서 계정 정보를 추출함
            Optional<TestAccount> maybeAccount =
                    accountRepository.findById(order.getTestAccount().getId());

            /*
                .isPresent() != .isEmpty()

                isEmpty는 값이 없으면,
                isPresent는 값이 존재하면 이다.
            */
            if(maybeAccount.isPresent()){
                final TestAccount testAccount = maybeAccount.get();
                final TestAccountResponseForm responseForm = new TestAccountResponseForm(
                        testAccount.getId(), testAccount.getEmail());

                responseFormList.add(responseForm);
            }
        }

        return responseFormList;
    }
}