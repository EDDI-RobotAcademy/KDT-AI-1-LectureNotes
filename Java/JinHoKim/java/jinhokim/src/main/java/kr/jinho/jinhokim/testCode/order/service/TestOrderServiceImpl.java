package kr.jinho.jinhokim.testCode.order.service;

import kr.jinho.jinhokim.testCode.account.entity.TestAccount;
import kr.jinho.jinhokim.testCode.account.repository.TestAccountRepository;
import kr.jinho.jinhokim.testCode.order.controller.form.TestAccountResponseForm;
import kr.jinho.jinhokim.testCode.order.controller.form.TestOrderAccountRequestForm;
import kr.jinho.jinhokim.testCode.order.controller.form.TestOrderListRequestForm;
import kr.jinho.jinhokim.testCode.order.controller.form.TestOrderRequestForm;
import kr.jinho.jinhokim.testCode.order.entity.TestOrder;
import kr.jinho.jinhokim.testCode.order.repository.TestOrderRepository;
import kr.jinho.jinhokim.testCode.product.entity.TestProduct;
import kr.jinho.jinhokim.testCode.product.repository.TestProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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

    private Long alwaysReturnFirst(String userToken) {
        return 1L;
    }

    @Override
    public TestOrder order(TestOrderRequestForm requestForm) {
        final TestAccount account = isValidateAccount(alwaysReturnFirst(requestForm.getUserToken()));
        if (account == null) {
            return null;
        }

        final Optional<TestProduct> maybeProduct = productRepository.findById(requestForm.getProductId());

        if (maybeProduct.isEmpty()) {
            log.debug("주문을 진행할 수 없습니다!");
            return null;
        }

        final TestProduct product = maybeProduct.get();

        return orderRepository.save(new TestOrder(account,product));
    }

    @Override
    public List<TestOrder> orderListForAccount(TestOrderListRequestForm orderListRequestForm) {
        final TestAccount account = isValidateAccount(alwaysReturnFirst(orderListRequestForm.getUserToken()));

        if (account == null) {
            return null;
        }
        return orderRepository.findAllByAccountId(account.getId());
    }

    @Override
    public List<TestAccountResponseForm> findAllAccountWhoBuyProduct(TestOrderAccountRequestForm requestForm) {
        List<TestOrder> orderList =
                orderRepository.findAllAccountWhoBuyProduct(requestForm.getProductId());

        List<TestAccountResponseForm> responseFormList = new ArrayList<>();

        for (TestOrder order : orderList) {
            Optional<TestAccount> maybeAccount =
                    accountRepository.findById(order.getTestAccount().getId());

            if (maybeAccount.isPresent()) {
                final TestAccount testAccount = maybeAccount.get();
                final TestAccountResponseForm responseForm = new TestAccountResponseForm(testAccount.getId(), testAccount.getEmail());
                responseFormList.add(responseForm);
            }
        }
        return responseFormList;
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
