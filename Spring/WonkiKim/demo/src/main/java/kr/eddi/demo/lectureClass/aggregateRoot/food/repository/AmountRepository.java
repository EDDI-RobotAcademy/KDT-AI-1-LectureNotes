package kr.eddi.demo.lectureClass.aggregateRoot.food.repository;

import kr.eddi.demo.lectureClass.aggregateRoot.food.entity.Amount;
import kr.eddi.demo.lectureClass.aggregateRoot.food.entity.AmountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmountRepository extends JpaRepository<Amount, Long> {
    Amount findByAmountType(AmountType amountType);
}
