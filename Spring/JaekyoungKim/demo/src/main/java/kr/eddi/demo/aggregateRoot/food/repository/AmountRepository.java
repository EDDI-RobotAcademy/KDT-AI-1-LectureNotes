package kr.eddi.demo.aggregateRoot.food.repository;

import kr.eddi.demo.aggregateRoot.food.entity.Amount;
import kr.eddi.demo.aggregateRoot.food.entity.AmountType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AmountRepository extends JpaRepository<Amount,Long> {
    Optional<Amount> findByAmountType(AmountType amountType);
}