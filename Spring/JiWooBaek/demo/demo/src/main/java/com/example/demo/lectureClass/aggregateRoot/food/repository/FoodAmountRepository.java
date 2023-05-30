package com.example.demo.lectureClass.aggregateRoot.food.repository;

import com.example.demo.lectureClass.aggregateRoot.food.entity.FoodAmount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodAmountRepository extends JpaRepository<FoodAmount, Long> {
}
