package com.example.demo.problem.order.service;

import com.example.demo.problem.account.entity.Account;
import com.example.demo.problem.account.entity.Role;
import com.example.demo.problem.account.repository.AccountRepository;
import com.example.demo.problem.account.repository.AccountRoleRepository;
import com.example.demo.problem.account.repository.UserTokenRepository;
import com.example.demo.problem.account.repository.UserTokenRepositoryImpl;
import com.example.demo.problem.order.controller.form.OrderResponseForm;
import com.example.demo.problem.order.repository.OrderRepository;
import com.example.demo.problem.order.entity.Orders;
import com.example.demo.problem.order.service.request.OrderRegisterRequest;
import com.example.demo.problem.product.entity.Product;
import com.example.demo.problem.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.demo.problem.account.entity.RoleType.NORMAL;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    final private OrderRepository orderRepository;
    final private AccountRepository accountRepository;
    final private AccountRoleRepository accountRoleRepository;
    final private ProductRepository productRepository;

    final private UserTokenRepository userTokenRepository = UserTokenRepositoryImpl.getInstance();

    @Override
    public Boolean register(Long id, OrderRegisterRequest orderRegisterRequest) {
        final Optional<Account> maybeAccount = accountRepository.findById(id);

        if (maybeAccount.isEmpty()) {
            return null;
        }

        final Account account = maybeAccount.get();
        final Role role = accountRoleRepository.findRoleInfoByAccount(account);

        if (role.getRoleType() != NORMAL) {
            return null;
        }

        final Optional<Product> maybeProduct = productRepository.findById(orderRegisterRequest.getProductId());

        if (maybeProduct.isEmpty()) {
            return null;
        }

        final Orders orders = new Orders(maybeProduct.get(), account);
        orderRepository.save(orders);

        return true;
    }

    public List<OrderResponseForm> orderList (Long accountId) {
//        final Optional<Account> maybeAccount = accountRepository.findById(accountId);
//        if (maybeAccount.isEmpty()) {
//            return null;
//        }
//        final Account account = maybeAccount.get();
        final List<Object[]> ordersList = orderRepository.findAllProductInfoByAccount(accountId);
        final List<OrderResponseForm> responseFormList = new ArrayList<>();

        for (Object[] row : ordersList) {
            Long productId = (Long) row[0];
            String productDetails = (String) row[1];
            String productName = (String) row[2];
            Integer productPrice = (Integer) row[3];

            System.out.println("Product ID: " + productId);
            System.out.println("Product Details: " + productDetails);
            System.out.println("Product Name: " + productName);
            System.out.println("Product Price: " + productPrice);
            System.out.println("------------------------");

            responseFormList.add(new OrderResponseForm(productId, productName, productPrice, productDetails));
        }

        return responseFormList;
    }
}
