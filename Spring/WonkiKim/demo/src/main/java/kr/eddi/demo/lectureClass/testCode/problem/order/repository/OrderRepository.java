package kr.eddi.demo.lectureClass.testCode.problem.order.repository;

import kr.eddi.demo.lectureClass.testCode.problem.member.entity.Member;
import kr.eddi.demo.lectureClass.testCode.problem.order.entity.OrderEntity;
import kr.eddi.demo.lectureClass.testCode.problem.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findAllByMember(Member member);

    List<OrderEntity> findAllByProduct(Product product);
}