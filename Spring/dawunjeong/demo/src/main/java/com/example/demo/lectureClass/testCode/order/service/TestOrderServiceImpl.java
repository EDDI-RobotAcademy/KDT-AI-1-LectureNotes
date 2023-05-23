package com.example.demo.lectureClass.testCode.order.service;

import com.example.demo.lectureClass.testCode.account.entity.account.TestAccount;
import com.example.demo.lectureClass.testCode.account.repository.account.TestAccountRepository;
import com.example.demo.lectureClass.testCode.order.controller.form.TestAccountResponseForm;
import com.example.demo.lectureClass.testCode.order.controller.form.TestOrderAccountRequestForm;
import com.example.demo.lectureClass.testCode.order.controller.form.TestOrderListRequestForm;
import com.example.demo.lectureClass.testCode.order.controller.form.TestOrderRequestForm;
import com.example.demo.lectureClass.testCode.order.entity.TestOrder;
import com.example.demo.lectureClass.testCode.order.repository.TestOrderRepository;
import com.example.demo.lectureClass.testCode.product.entity.TestProduct;
import com.example.demo.lectureClass.testCode.product.repository.TestProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestOrderServiceImpl implements TestOrderService{

    final private TestAccountRepository accountRepository;
    final private TestProductRepository productRepository;
    final private TestOrderRepository orderRepository;

    // 지금 redis를 쓸 수 없으므로 임시 방편용
    private Long alwaysReturnFirst (String userToken, Long accountId) {
        return accountId;
    }

    // 특정 상품을 구매한 회원 찾기(정다운)
    private Long alwaysProductReturnFirst (Long productId) {
        return productId;
    }

    @Override
    public TestOrder order(TestOrderRequestForm requestForm, Long accountId) {
        final TestAccount account = isValidateAccount(alwaysReturnFirst(requestForm.getUserToken(), accountId));
        if (account == null) return null;

        final Optional<TestProduct> maybeProduct = productRepository.findById(requestForm.getProductId());

        if(maybeProduct.isEmpty()) {
            log.debug("주문을 진행할 수 없습니다!");
            return null;
        }

        final TestProduct product = maybeProduct.get();

        return orderRepository.save(new TestOrder(account, product));

    }

    @Override
    public List<TestOrder> orderListForAccount(TestOrderListRequestForm orderListRequestForm, Long accountId) {
        final TestAccount account = isValidateAccount(
                alwaysReturnFirst(orderListRequestForm.getUserToken(), accountId));

        if(account == null ) return null;

        return orderRepository.findAllByAccountId(account.getId());
    }

    // 특정 상품을 구매한 회원 찾기(선생님 풀이)
    @Override
    public List<TestAccountResponseForm> findAllAccountWhoBuyProduct(
            TestOrderAccountRequestForm requestForm) {

        List<TestOrder> orderList =
                orderRepository.findAllAccountWhoBuyProduct(requestForm.getProductId());
        // accountId만 따로 추출이 필요
        List<TestAccountResponseForm> responseFormList = new ArrayList<>();

        for (TestOrder order: orderList) {
            Optional<TestAccount> maybeAccount =
                    accountRepository.findById(order.getTestAccount().getId());

            if (maybeAccount.isPresent()) {
                final TestAccount testAccount = maybeAccount.get();
                final TestAccountResponseForm responseForm = new TestAccountResponseForm(
                        testAccount.getId(), testAccount.getEmail());

                responseFormList.add(responseForm);
            }
        }

        return responseFormList;
    }

    // 특정 상품을 구매한 회원 찾기(정다운)
    @Override
    public List<TestOrder> findAllOrderWhoBuyProduct(TestOrderAccountRequestForm orderAccountRequestForm) {
        final TestProduct product = isValidateProduct(
                alwaysProductReturnFirst(orderAccountRequestForm.getProductId()));

        if(product == null ) return null;

        return orderRepository.findAllByProductId(product.getId());
    }

    private TestProduct isValidateProduct(Long productId) {
        final Optional<TestProduct> maybeProduct = productRepository.findById(productId);

        if(maybeProduct.isEmpty()) {
            log.debug("주문을 진행할 수 없습니다!");
            return null;
        }

        return maybeProduct.get();
    }

    private TestAccount isValidateAccount(Long accountId) {
        final Optional<TestAccount> maybeAccount = accountRepository.findById(accountId);

        if(maybeAccount.isEmpty()) {
            log.debug("주문을 진행할 수 없습니다!");
            return null;
        }

        return maybeAccount.get();
    }
}
