package kr.eddi.demo.testCode.order.repository;

import kr.eddi.demo.testCode.order.entity.TestOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestOrderRepository extends JpaRepository<TestOrder,Long> {
}
