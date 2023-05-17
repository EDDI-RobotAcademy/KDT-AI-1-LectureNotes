package com.example.demo.lectureClass.aggregateRoot.food.repository;

import com.example.demo.lectureClass.aggregateRoot.food.entity.Category;
import com.example.demo.lectureClass.aggregateRoot.food.entity.CategoryType;
import com.example.demo.lectureClass.aggregateRoot.food.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByCategoryType(CategoryType categoryType);
}
