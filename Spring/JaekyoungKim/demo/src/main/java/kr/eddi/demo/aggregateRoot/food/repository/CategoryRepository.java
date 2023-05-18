package kr.eddi.demo.aggregateRoot.food.repository;

import kr.eddi.demo.aggregateRoot.food.entity.Category;
import kr.eddi.demo.aggregateRoot.food.entity.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findByCategoryType(CategoryType categoryType);
}
