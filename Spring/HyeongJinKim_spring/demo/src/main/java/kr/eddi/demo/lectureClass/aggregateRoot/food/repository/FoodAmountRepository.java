package kr.eddi.demo.lectureClass.aggregateRoot.food.repository;

import kr.eddi.demo.lectureClass.aggregateRoot.food.entity.FoodAmount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodAmountRepository extends JpaRepository<FoodAmount, Long> {
}
