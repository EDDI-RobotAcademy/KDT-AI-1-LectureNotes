package com.example.demo.lectureClass.order.repository;

import com.example.demo.lectureClass.order.entity.TestOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestOrderRepository extends JpaRepository<TestOrder, Long> {
}
