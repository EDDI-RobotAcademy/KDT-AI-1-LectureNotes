package kr.eddi.demo.testCode.order.service;

import kr.eddi.demo.testCode.order.controller.form.TestAccountResponseForm;
import kr.eddi.demo.testCode.account.entity.TestAccount;
import kr.eddi.demo.testCode.account.repository.TestAccountRepository;
import kr.eddi.demo.testCode.order.controller.form.TestOrderAccountRequestForm;
import kr.eddi.demo.testCode.order.controller.form.TestOrderListRequestForm;
import kr.eddi.demo.testCode.order.controller.form.TestOrderRequestForm;
import kr.eddi.demo.testCode.order.entity.TestOrder;
import kr.eddi.demo.testCode.order.repository.TestOrderRepository;
import kr.eddi.demo.testCode.product.entity.TestProduct;
import kr.eddi.demo.testCode.product.repository.TestProductRepository;
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
        // 유저 토큰과 상품 id 계정 id가 넘어온다.
        final TestAccount account = isValidateAccount(
                alwaysReturnFirst(requestForm.getUserToken(), accountId));
            // 항상 어카운트 아이디로만 검색함
        if (account == null) return null;
        // 어카운트가 비엇으면 주문 불가능하다.

        final Optional<TestProduct> maybeProduct = productRepository.findById(requestForm.getProductId());
        //가져온 프로덕트 아이디로 저장소에서 검색한다.
        // 있을 경우 maybeProduct가 생김
        if (maybeProduct.isEmpty()) {
            //상품이 없으면 주문 불가
            log.debug("주문을 진행할 수 없습니다!");
            return null;
        }
        final TestProduct product = maybeProduct.get();
        // 상품이 있기 때문에 주문 가능
        // 가져온 어카운트와 프로덕트를 오더 래포지토리에 저장한다.
        return orderRepository.save(new TestOrder(account, product));
    }

    @Override
    public List<TestOrder> orderListForAccount(
            TestOrderListRequestForm orderListRequestForm, Long accountId) {
        final TestAccount account = isValidateAccount(
                // 어카운트 아이로 검색한다. 있으면 가져와라
                alwaysReturnFirst(orderListRequestForm.getUserToken(), accountId));

        if (account == null) return null;
            // 해당 아이디로 주문한 데이터를 래포지토리에서 가져온다. 다 가져오므로 리스트임
        return orderRepository.findAllByAccountId(account.getId());
    }



    @Override
    public List<TestAccountResponseForm> findAllAccountWhoBuyProduct(TestOrderAccountRequestForm requestForm) {
        // 리퀘스트폼으로 받아온 정보가 있다.
        List<TestAccountResponseForm> responseFormList=new ArrayList<>();
        //비어있는 아이디와 이메일 리스트를 만들어 준다.
        List<TestOrder> orderList=orderRepository.findAllAccountWhoBuyProduct(requestForm.getProductId());
        //리퀘스트 폼에서 프로덕트 id를 뽑아서 래포지토리의 정보들을 가져온다. 옵셔널이 아닌건 리스트이기 때문에
        for (TestOrder order: orderList){
            // 가져 리스트의 주문 갯수 만큼 진행할 것이다.
        Optional<TestAccount> maybeAccount=accountRepository.findById(order.getTestAccount().getId());
        // 주문 내역의 계정의 id로 검색한 계정이 어카운트에 있을 겨웅 maybeAccount에 정보를 채운다.
        if (maybeAccount.isPresent()){
            // 메이비에 정보가 들어온 경우
            // 옵셔널이기 때문에 get으로 어카운트 가져온다.
            final TestAccount testAccount =maybeAccount.get();
            // 어카운트에서 이메일과 아이디를 빼서 리스폰스폼을 만든다.
            final TestAccountResponseForm responseForm= new TestAccountResponseForm(
            testAccount.getId(),testAccount.getEmail());
            // 위의 비어잇는 리스트에 해당 폼 넣어준다.
            responseFormList.add(responseForm);
        }
        }
        return responseFormList;
        // 내역을 리턴해 준다.
    }


    private TestAccount isValidateAccount(Long accountId) {
        final Optional<TestAccount> maybeAccount = accountRepository.findById(accountId);
        // 어카운트 래포지토리에서 해당 값이 있으면 값을 가져와라

        if (maybeAccount.isEmpty()) {
            log.debug("주문을 진행할 수 없습니다!");
            return null;
        }// 어카운트가 비었으면 주문 물가띠
        return maybeAccount.get();
    }
}
