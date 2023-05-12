package com.example.demo.lectureClass.testCode.order.service;



import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import com.example.demo.lectureClass.testCode.account.repository.TestAccountRepository;
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
    final private TestOrderRepository orderRepository;
    final private TestProductRepository productRepository;

    private Long alwaysReturnFirst(String userToken, Long accountId){
        return accountId;
    }
    @Override
    public TestOrder order(TestOrderRequestForm requestForm, Long accountId){
        final TestAccount account =
                isValidateAccount(alwaysReturnFirst(requestForm.getUserToken(),accountId));
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
    public List<TestOrder> orderListForAccount(TestOrderListRequestForm orderListRequestForm, Long accountId) {
        final TestAccount account = isValidateAccount(
                alwaysReturnFirst(orderListRequestForm.getUserToken(),accountId));

        if (account == null) return null;

        return orderRepository.findAllByAccountId(account.getId());
        //return orderRepository.findAllByTestAccount(account); Query 안쓸경우에 이렇게 사용
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
    public List<TestAccountResponseForm> FindAllAccountWhoBuyProduct(
            TestOrderAccountRequestForm requestForm) {
        List<TestOrder> orderList =
                orderRepository.findAllAccountWhoBuyProduct(requestForm.getProductId());
        //OrderRepository에서 requestForm으로 받은 productId 해당 Order들 찾기
        //accountId만 따로 추출이 필요
        List<TestAccountResponseForm> responseFormList =new ArrayList<>(); //TestAccountResponseForm형태의 리스트들 생성

        for(TestOrder order: orderList) { // order에 orderList 넣기 찾은order들 하나씩 넣기
            Optional<TestAccount> maybeAccount =
                    accountRepository.findById(order.getTestAccount().getId());
            //accountRepository에서 id(위의 order에를 찾아서 account를 만들꺼야
            if (maybeAccount.isPresent()) {
                TestAccount testAccount = maybeAccount.get();
                final TestAccountResponseForm responseForm = new TestAccountResponseForm(
                        testAccount.getId(), testAccount.getEmail());
                responseFormList.add(responseForm);
            }
        }
        return responseFormList;
    }
}
