package kr.eddi.demo.lectureClass.testCode.problem.order.repository;

import kr.eddi.demo.lectureClass.testCode.problem.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}