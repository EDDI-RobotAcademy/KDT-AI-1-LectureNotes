package com.example.demo.evaluation.problem27_30.service;

import com.example.demo.evaluation.problem10_14_17_20.entity.Account;
import com.example.demo.evaluation.problem10_14_17_20.entity.AccountRole;
import com.example.demo.evaluation.problem10_14_17_20.entity.RoleType;
import com.example.demo.evaluation.problem10_14_17_20.repository.AccountRepository;
import com.example.demo.evaluation.problem10_14_17_20.repository.AccountRoleRepository;
import com.example.demo.evaluation.problem21_26.entity.Product;
import com.example.demo.evaluation.problem21_26.repository.ProductRepository;
import com.example.demo.evaluation.problem27_30.controller.OrderRequestForm;
import com.example.demo.evaluation.problem27_30.entity.SampleOrder;
import com.example.demo.evaluation.problem27_30.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.demo.evaluation.problem10_14_17_20.entity.RoleType.NORMAL;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    final private AccountRepository accountRepository;
    final private ProductRepository productRepository;
    final private OrderRepository orderRepository;
    final private AccountRoleRepository accountRoleRepository;
    Boolean isNormalAccount = false;
    @Override
    public SampleOrder order(OrderRequestForm orderRequestForm, Long accountId) {
        RoleType roleType = NORMAL;
        Optional<Account> maybeAccount = accountRepository.findById(accountId);
        Optional<AccountRole> maybeAccountRole = accountRoleRepository.findByAccount(maybeAccount);
        Optional<Product> maybeProduct = productRepository.findById(orderRequestForm.getProductId());

        if(maybeAccount.isEmpty() && maybeProduct.isEmpty()) {
            return null;
        }

        if(roleType == maybeAccountRole.get().getRole().getRoleType()) {
            isNormalAccount = true;
        }

        if(isNormalAccount){
            final Account account = maybeAccount.get();
            final Product product = maybeProduct.get();

            final SampleOrder sampleOrder = new SampleOrder(account, product);
            orderRepository.save(sampleOrder);

            return sampleOrder;
        }
        return null;
    }

    @Override
    public List<SampleOrder> list(Long accountId) {
        Optional<Account> maybeAccount = accountRepository.findById(accountId);

        List<SampleOrder> orderList = orderRepository.findAllByAccount(maybeAccount);
        log.info("몇개 주문하셨나요 : " + orderList.size());
        return orderList;
    }
}
