package kr.eddi.demo.lectureClass.aggregateRoot.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
