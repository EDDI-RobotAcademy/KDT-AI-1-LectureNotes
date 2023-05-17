package kr.eddi.demo.aggregateRoot.food.repository;

import kr.eddi.demo.aggregateRoot.food.entity.Category;
import kr.eddi.demo.aggregateRoot.food.entity.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory,Long> {
}
