package kr.eddi.demo.testCode.order.service;

import kr.eddi.demo.testCode.account.entity.TestAccount;
import kr.eddi.demo.testCode.account.repository.TestAccountRepository;
import kr.eddi.demo.testCode.order.controller.form.TestOrderRequestForm;
import kr.eddi.demo.testCode.order.entity.TestOrder;
import kr.eddi.demo.testCode.order.repository.TestOrderRepository;
import kr.eddi.demo.testCode.product.entity.TestProduct;
import kr.eddi.demo.testCode.product.repository.TestProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestOrderServiceImpl implements TestOrderService{

final private TestAccountRepository accountRepository;
final private TestOrderRepository orderRepository;
final private TestProductRepository productRepository;
    private Long alwaysReturnFirst(String userToken){// 지금 redis를 쓸 수 없으므로 임시 방편용
        return 1L;
    }
    //TODO 이거 왜 필요하지..? => 스프링?이랑 연결안해서 임시로 id 부여한것

    @Override
    public TestOrder order(TestOrderRequestForm requestForm){
        final Long accountId = alwaysReturnFirst(requestForm.getUserToken());

        final Optional<TestAccount> maybeAccount = accountRepository.findById(accountId);
        if(maybeAccount.isEmpty()) {
            log.debug("주문을 진행할 수 없습니다."); //등록된 Id가 아니라서
            return null;
        }
        final TestAccount account = maybeAccount.get();

        final Optional<TestProduct> maybeProduct = productRepository.findById(requestForm.getProductId());

        if(maybeProduct.isEmpty()){
            log.debug("주문을 진행할 수 없습니다."); //등록된 상품Id가 아님
            return null;
        }
        final  TestProduct product = maybeProduct.get();
        // 등록된Id고 등록된 상품Id라면?

        return orderRepository.save(new TestOrder(account, product));
    }
}
