package com.example.demo.lectureClass.order.service;

import com.example.demo.lectureClass.account.entity.TestAccount;
import com.example.demo.lectureClass.account.repository.TestAccountRepository;
import com.example.demo.lectureClass.order.controller.form.TestOrderRequestForm;
import com.example.demo.lectureClass.order.entity.TestOrder;
import com.example.demo.lectureClass.order.repository.TestOrderRepository;
import com.example.demo.lectureClass.product.entity.TestProduct;
import com.example.demo.lectureClass.product.reposiory.TestProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestOrderServiceImpl implements TestOrderService{
    final private TestAccountRepository accountRepository;
    final private TestProductRepository productRepository;
    final private TestOrderRepository orderRepository;

    // 지금 redis를 쓸 수 없으므로 임시 방편용
    private Long alwaysReturnFirst (String userToken) {
        return 1L;
    }

    @Override
    public TestOrder order(TestOrderRequestForm requestForm) {
        final Long accountId = alwaysReturnFirst(requestForm.getUserToken());
        final Optional<TestAccount> maybeAccount = accountRepository.findById(accountId);

        if (maybeAccount.isEmpty()) {
            log.debug("주문을 진행할 수 없습니다!");
            return null;
        }
        final TestAccount account = maybeAccount.get();

        final Optional<TestProduct> maybeProduct = productRepository.findById(requestForm.getProductId());

        if (maybeProduct.isEmpty()) {
            log.debug("주문을 진행할 수 없습니다!");
            return null;
        }
        final TestProduct product = maybeProduct.get();

        return orderRepository.save(new TestOrder(account, product));
    }
}
