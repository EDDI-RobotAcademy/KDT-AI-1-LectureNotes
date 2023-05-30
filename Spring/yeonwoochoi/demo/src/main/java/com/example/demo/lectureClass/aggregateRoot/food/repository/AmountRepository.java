package com.example.demo.lectureClass.aggregateRoot.food.repository;

import com.example.demo.lectureClass.aggregateRoot.food.entity.Amount;
import com.example.demo.lectureClass.aggregateRoot.food.entity.AmountType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AmountRepository extends JpaRepository<Amount, Long> {
    Optional<Amount> findByAmountType(AmountType amountType);
}
