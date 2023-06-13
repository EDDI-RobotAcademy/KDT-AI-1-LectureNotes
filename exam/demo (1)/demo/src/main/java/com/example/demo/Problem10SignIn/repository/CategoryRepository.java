package com.example.demo.Problem10SignIn.repository;

import com.example.demo.Problem10SignIn.entity.Category;
import com.example.demo.Problem10SignIn.entity.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByCategoryType(CategoryType categoryType);
}
