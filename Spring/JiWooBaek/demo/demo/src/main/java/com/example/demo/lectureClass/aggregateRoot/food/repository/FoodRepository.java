package com.example.demo.lectureClass.aggregateRoot.food.repository;

import com.example.demo.lectureClass.aggregateRoot.food.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
