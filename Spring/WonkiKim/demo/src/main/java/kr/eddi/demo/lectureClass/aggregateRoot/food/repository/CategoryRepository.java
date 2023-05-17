package kr.eddi.demo.lectureClass.aggregateRoot.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
