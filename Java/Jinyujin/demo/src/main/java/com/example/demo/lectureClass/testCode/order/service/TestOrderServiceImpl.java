package com.example.demo.lectureClass.testCode.order.service;

import com.example.demo.lectureClass.testCode.account.controller.form.TestAccountResponseForm;
import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import com.example.demo.lectureClass.testCode.account.repository.TestAccountRepository;
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

    /*
        주문이 들어오면 일단 사용자가 누군지 판별해야 함
        그래서 위에 로그인에 대한 작업을 가져옴
        근데 이 패턴이 반복될 것 -> private 메서드로 빼기: isValidateAccount()
        오더리퍼지토리 부르기
        그럼 사용자가 맞는지 확인하고 null을 리턴하고 있는 사용자의 아이디를 다 받아오는 메서드가 생성되었다
        findAllByAccountId 자동완성 안되고 어제 bean creation 오류 발생
        -> 이거 이름 그냥 Id라고 했을 때 똑같은 오류 나는지 확인하기
        아 어카운트 아이디인데 오더 저장소에서 만든 것이라서 상관없는 것 같기도 함
        그래도 한번 해보기
        어제는 해당 엔티티에 있는 변수 가져오는 거였고
        오늘은 해당 엔티티에 있는 엔티티의 변수를 가져오는 거라서 안될 것 같기도 함
     */

    @Override
    public List<TestOrder> orderListForAccount(
            TestOrderListRequestForm orderListRequestForm, Long accountId) {

        final TestAccount account = isValidateAccount(
                alwaysReturnFirst(orderListRequestForm.getUserToken(), accountId));

        if (account == null) return null;

        return orderRepository.findAllByAccountId(account.getId());
    }

    @Override
    public List<TestAccountResponseForm> findAllAccountWhoBuyProduct(TestOrderAccountRequestForm requestForm) {
        // order저장소에서 주문한 상품의 리스트 뽑기
        List<TestOrder> orderList = orderRepository.findAllAccountWhoBuyProduct(requestForm.getProductId());
        // repository에서 findAllAccountWhoBuyProduct 이걸로 productId를 찾아줬어야 함
        // 일단 전체 주문된 상품 찾아오고 그거에 해당하는 accountId를 찾아주기

        List<TestAccountResponseForm> accountResponseFormList = new ArrayList<>();

        // 그 상품을 산 사람들의 id값 찾아오기
        for(TestOrder order: orderList) {
            Optional<TestAccount> maybeAccount = accountRepository.findById(order.getTestAccount().getId());
            // 일단 전체 주문된 상품 찾아오고 그거에 해당하는 accountId를 찾아주기

            if (maybeAccount.isPresent()) {
                final TestAccount testAccount = maybeAccount.get();
                // 먼저 testAccount에 찾아온 accountId 담아주고
                final TestAccountResponseForm accountResponseForm =
                        new TestAccountResponseForm(testAccount.getId(), testAccount.getEmail());
                // 그걸 다시 TestAccountResponseForm에 담아서 객체로 만들고 accountResponseForm에 저장해주기

                accountResponseFormList.add(accountResponseForm);
            }
        }

        return accountResponseFormList;
        // 없으면 자동으로 null 반환
    }
    // 흐름에 대한 이해가 더 필요한 것 같음
    // 레퍼지토리에서 그 아이디를 왜 찾아야 하는건지
    // 어디서 그 아이디를 찾아와야 하는지 정확하게 파악할 것

    private TestAccount isValidateAccount(Long accountId) {
        final Optional<TestAccount> maybeAccount = accountRepository.findById(accountId);

        if (maybeAccount.isEmpty()) {
            log.debug("주문을 진행할 수 없습니다!");
            return null;
        }
        return maybeAccount.get();
    }
}
