package com.example.demo.lectureClass.aggregateRoot.repository;

import com.example.demo.lectureClass.aggregateRoot.entity.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
