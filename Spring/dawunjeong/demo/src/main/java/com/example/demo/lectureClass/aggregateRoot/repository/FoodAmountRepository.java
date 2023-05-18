package com.example.demo.lectureClass.aggregateRoot.repository;

import com.example.demo.lectureClass.aggregateRoot.entity.FoodAmount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodAmountRepository extends JpaRepository<FoodAmount, Long> {
}
