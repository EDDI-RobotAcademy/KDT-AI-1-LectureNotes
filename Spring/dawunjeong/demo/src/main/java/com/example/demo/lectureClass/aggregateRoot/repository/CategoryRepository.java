package com.example.demo.lectureClass.aggregateRoot.repository;

import com.example.demo.lectureClass.aggregateRoot.entity.Category;
import com.example.demo.lectureClass.aggregateRoot.entity.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByCategoryType(CategoryType categoryType);
}
