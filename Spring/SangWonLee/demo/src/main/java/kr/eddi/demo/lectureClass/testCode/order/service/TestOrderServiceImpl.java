package kr.eddi.demo.lectureClass.testCode.order.service;

import kr.eddi.demo.lectureClass.testCode.account.entity.TestAccount;
import kr.eddi.demo.lectureClass.testCode.account.repository.TestAccountRepository;
import kr.eddi.demo.lectureClass.testCode.order.controller.form.TestAccountResponseForm;
import kr.eddi.demo.lectureClass.testCode.order.controller.form.TestOrderAccountRequestForm;
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

    private Long alwaysReturnFirst(String userToken, Long accountId) {
        return accountId;
        // userToken을 인자로 받아 항상 1L로 반환.
        // Redis를 사용할 수 없을 때 임시로 사용하는 방법이다.
        // 원래는 Redis를 사용하여 userToken을 검증하려고 할거임
    }

    @Override
    public TestOrder order(TestOrderRequestForm requestForm, Long accountId) {
        final TestAccount account = isValidateAccount(
                alwaysReturnFirst(requestForm.getUserToken(), accountId));
        // userToken을 받아서 계정이 있는지 없는지 확인한다.
        // 여기서는 Redis로 확인하려고 하지만 아직 배우지 않은 상태이므로,
        //  1로 반환시켜서 진행

        if (account == null) return null;
        // 없으면 null

        final Optional<TestProduct> maybeProduct = productRepository.findById(requestForm.getProductId());
        // productId 가 있는지 없는지 확인

        if (maybeProduct.isEmpty()) {
            log.debug("주문을 진행할 수 없습니다!");
            return null;
        }
        final TestProduct product = maybeProduct.get();
        // 있으면 TestProduct로 값 가져와서

        return orderRepository.save(new TestOrder(account, product));
        // account, product를 인자로 jpa로 save한다.
    }

    @Override
    public List<TestOrder> orderListForAccount(
            TestOrderListRequestForm orderListRequestForm, Long accountId) {

        final TestAccount account = isValidateAccount(
                alwaysReturnFirst(orderListRequestForm.getUserToken(), accountId));
        // usertoken, accountId로 계정이 있는지 확인한다.
        // alwaysReturnFirst 해서 현재는 token 검증 못하고 있어서 중간이 빠져있다.

        if (account == null) return null;
        // 없다면 null (테스트 실패)

        return orderRepository.findAllByAccountId(account.getId());
        // Spring Data JPA로 accountId와 일치하는 모든 주문을 검색한다.
    }

    @Override
    public List<TestAccountResponseForm> findAllAccountWhoBuyProduct(
            TestOrderAccountRequestForm requestForm) {

        List<TestOrder> orderList =
                orderRepository.findAllAccountWhoBuyProduct(requestForm.getProductId());
        // TestOrderAccountRequestForm에서 product.Id를 얻어와서
        // DB에서 일치하는 것들을 모두 조회해서 orderList에 넣는다.

        List<TestAccountResponseForm> responseFormList = new ArrayList<>();
        // TestAccountResponseForm 객체의 목록을 저장하는데 사용

        for (TestOrder order : orderList) {
            // orderList를 반복
            Optional<TestAccount> maybeAccount =
                    accountRepository.findById(order.getTestAccount().getId());
            // TestOrder에서 저장된 Id를 가져와서 DB에 존재할 수도 있고 존재하지 않을 수도 있는 값을
            // maybeAccount 변수에 할당한다.

            if (maybeAccount.isPresent()) { // 만약 존재한다면
                final TestAccount testAccount = maybeAccount.get(); // Account Class 정보를 받아서
                final TestAccountResponseForm responseForm = new TestAccountResponseForm(
                        testAccount.getId(), testAccount.getEmail());
                // TestAccountResponseForm 객체를 만든다.

                responseFormList.add(responseForm);
            }
        }

        return responseFormList;
        // 여기서 검색된 모든 계정의 정보를 포함 하는 TestAccountResponseForm 객체의 목록을 얻을 수 있다.
    }

    private TestAccount isValidateAccount(Long accountId) {
        final Optional<TestAccount> maybeAccount = accountRepository.findById(accountId);
        // 입력받은 accountId 로 accountRepository.findById 메소드를 호출하여 TextAccount 객체를 찾는다.
        // 없으면 빈 Optional이 반환되고, 있으면 Optional<TestAccount> 객체를 maybeAccount 변수에 저장한다.

        if (maybeAccount.isEmpty()) {
            log.debug("주문을 진행할 수 없습니다!");
            return null;
        }
        return maybeAccount.get();
        // 있으면 TestAccount 객체 값 반환.
    }
}