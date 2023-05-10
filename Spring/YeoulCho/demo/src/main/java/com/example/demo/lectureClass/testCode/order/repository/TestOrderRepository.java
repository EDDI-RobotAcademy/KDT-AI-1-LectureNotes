package com.example.demo.lectureClass.testCode.order.repository;

import com.example.demo.lectureClass.testCode.order.entity.TestOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestOrderRepository extends JpaRepository<TestOrder,Long> {
}
