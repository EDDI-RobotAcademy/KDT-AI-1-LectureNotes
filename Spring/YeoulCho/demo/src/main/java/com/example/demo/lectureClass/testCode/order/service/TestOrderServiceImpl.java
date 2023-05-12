package com.example.demo.lectureClass.testCode.order.service;



import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import com.example.demo.lectureClass.testCode.account.repository.TestAccountRepository;
import com.example.demo.lectureClass.testCode.order.controller.form.TestOrderListRequestForm;
import com.example.demo.lectureClass.testCode.order.controller.form.TestOrderRequestForm;
import com.example.demo.lectureClass.testCode.order.entity.TestOrder;
import com.example.demo.lectureClass.testCode.order.repository.TestOrderRepository;
import com.example.demo.lectureClass.testCode.product.entity.TestProduct;
import com.example.demo.lectureClass.testCode.product.repository.TestProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestOrderServiceImpl implements TestOrderService{
    final private TestAccountRepository accountRepository;
    final private TestOrderRepository orderRepository;
    final private TestProductRepository productRepository;

    private Long alwaysReturnFirst(String userToken){
        return 1L;
    }
    @Override
    public TestOrder order(TestOrderRequestForm requestForm){
        final TestAccount account =
                isValidateAccount(alwaysReturnFirst(requestForm.getUserToken()));
        if (account == null) return null;
        final Optional<TestProduct> maybeProduct = productRepository.findById(requestForm.getProductId());
        if(maybeProduct.isEmpty()){
            log.debug("주문을 진행할 수 없습니다.");
            return null;
        }
        final TestProduct product =maybeProduct.get();
        return orderRepository.save(new TestOrder(account,product));
    }

    @Override
    public List<TestOrder> orderListForAccount(TestOrderListRequestForm orderListRequestForm) {
        final TestAccount account = isValidateAccount(
                alwaysReturnFirst(orderListRequestForm.getUserToken()));

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



}
