package kr.eddi.demo.lectureClass.testCode.problem.order.service;

import kr.eddi.demo.lectureClass.testCode.problem.member.entity.Member;
import kr.eddi.demo.lectureClass.testCode.problem.member.repository.MemberRepository;
import kr.eddi.demo.lectureClass.testCode.problem.order.controller.form.OrderListByMemberRequestForm;
import kr.eddi.demo.lectureClass.testCode.problem.order.controller.form.OrderListByProductRequestForm;
import kr.eddi.demo.lectureClass.testCode.problem.order.controller.form.OrderListResponseForm;
import kr.eddi.demo.lectureClass.testCode.problem.order.controller.form.OrderRequestForm;
import kr.eddi.demo.lectureClass.testCode.problem.order.entity.OrderEntity;
import kr.eddi.demo.lectureClass.testCode.problem.order.repository.OrderRepository;
import kr.eddi.demo.lectureClass.testCode.problem.product.entity.Product;
import kr.eddi.demo.lectureClass.testCode.problem.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    final OrderRepository orderRepository;
    final MemberRepository memberRepository;
    final ProductRepository productRepository;
    public Long findMemberId(String userToken){
        return 1L;
    }

    public OrderEntity order(OrderRequestForm orderRequestForm) {
        Long memberId = findMemberId(orderRequestForm.getUserToken());
        Optional<Member> maybeMember = memberRepository.findById(memberId);

        if(maybeMember.isEmpty()) {
            log.debug("주문을 진행할 수 없음. - 비정상적인 UserToken감지");
            return null;
        }
        Optional<Product> maybeProduct = productRepository.findById(orderRequestForm.getProductId());
        if(maybeProduct.isEmpty()) {
            log.debug("주문을 진행할 수 없음. - 비정상적인 상품아이디 감지");
            return null;
        }
        log.debug("주문 정상 진행중");
        OrderEntity order = new OrderEntity(maybeMember.get(), maybeProduct.get());

        return orderRepository.save(order);
    }

    @Override
    public OrderListResponseForm serchOrderListByMember(OrderListByMemberRequestForm orderListByMemberRequestForm) {
        Long memberId = findMemberId(orderListByMemberRequestForm.getUserToken());
        Optional<Member> maybeMember = memberRepository.findById(memberId);

        if(maybeMember.isEmpty()) {
            log.debug("주문을 진행할 수 없음. - 비정상적인 UserToken감지");
            return null;
        }

        List<OrderEntity> orderList = orderRepository.findAllByMember(maybeMember.get());
        log.info(orderList.toString());
        return new OrderListResponseForm(orderList);
    }

    @Override
    public OrderListResponseForm serchOrderListByProduct(OrderListByProductRequestForm orderListByProductRequestForm) {
        Long productId = orderListByProductRequestForm.getProductId();
        Optional<Product> maybeProduct = productRepository.findById(productId);

        if(maybeProduct.isEmpty()) {
            log.debug("조회를 진행할 수 없음. - 비정상적인 상품id");
            return null;
        }
        List<OrderEntity> orderList = orderRepository.findAllByProduct(maybeProduct.get());
        return new OrderListResponseForm(orderList);
    }
}
