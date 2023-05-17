package com.example.demo.lectureClass.aggregateRoot.food.repository;

import com.example.demo.lectureClass.aggregateRoot.food.entity.FoodImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodImageRepository extends JpaRepository<FoodImage,Long> {
}
