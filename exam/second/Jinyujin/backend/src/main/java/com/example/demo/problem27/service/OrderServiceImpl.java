package com.example.demo.problem27.service;

import com.example.demo.problem10.entity.Member;
import com.example.demo.problem10.entity.MemberRole;
import com.example.demo.problem10.entity.Role;
import com.example.demo.problem10.entity.RoleType;
import com.example.demo.problem10.repository.MemberRoleRepository;
import com.example.demo.problem10.repository.RoleRepository;
import com.example.demo.problem21.entity.ProductExam;
import com.example.demo.problem21.repository.ProductRepository;
import com.example.demo.problem27.entity.Order;
import com.example.demo.problem27.form.OrderRequestForm;
import com.example.demo.problem27.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    final private MemberRoleRepository memberRoleRepository;
    final private ProductRepository productRepository;
    final private OrderRepository orderRepository;

    @Override
    public Order order(OrderRequestForm orderRequestForm, RoleType roleType) {

        final Optional<MemberRole> maybeMemberRole = memberRoleRepository.findByRole(roleType);

        if (maybeMemberRole.isEmpty()) {
            return null;
        }

        final Member member = maybeMemberRole.get().getMember();

        final Optional<ProductExam> maybeProduct =
                productRepository.findById(orderRequestForm.getProductId());

        if (maybeProduct.isEmpty()) {
            log.debug("주문을 진행할 수 없습니다!");
            return null;
        }
        final ProductExam product = maybeProduct.get();

        return orderRepository.save(new Order(member, product));
    }
}
