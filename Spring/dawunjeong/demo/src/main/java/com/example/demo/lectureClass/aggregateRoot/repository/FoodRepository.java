package com.example.demo.lectureClass.aggregateRoot.repository;

import com.example.demo.lectureClass.aggregateRoot.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
