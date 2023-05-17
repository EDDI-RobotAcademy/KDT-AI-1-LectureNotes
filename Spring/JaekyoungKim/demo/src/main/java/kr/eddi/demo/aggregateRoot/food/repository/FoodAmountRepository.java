package kr.eddi.demo.aggregateRoot.food.repository;

import kr.eddi.demo.aggregateRoot.food.entity.FoodAmount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodAmountRepository extends JpaRepository<FoodAmount,Long> {
}
