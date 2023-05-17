package kr.eddi.demo.aggregateRoot.food.repository;

import kr.eddi.demo.aggregateRoot.food.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
