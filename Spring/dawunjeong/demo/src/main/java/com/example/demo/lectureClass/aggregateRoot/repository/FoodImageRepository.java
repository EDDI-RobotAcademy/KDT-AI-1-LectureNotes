package com.example.demo.lectureClass.aggregateRoot.repository;

import com.example.demo.lectureClass.aggregateRoot.entity.FoodImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodImageRepository extends JpaRepository<FoodImage, Long> {
}
