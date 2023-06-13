package com.example.demo.problem27.repository;

import com.example.demo.problem27.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
