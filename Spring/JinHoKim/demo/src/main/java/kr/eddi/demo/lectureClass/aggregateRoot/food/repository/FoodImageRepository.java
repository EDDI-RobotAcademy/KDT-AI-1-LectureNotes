package kr.eddi.demo.lectureClass.aggregateRoot.food.repository;

import kr.eddi.demo.lectureClass.aggregateRoot.food.entity.FoodImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodImageRepository extends JpaRepository<FoodImage, Long> {
}
