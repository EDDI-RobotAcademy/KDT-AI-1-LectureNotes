package com.example.demo.lectureClass.aggregateRoot.repository;

import com.example.demo.lectureClass.aggregateRoot.entity.Amount;
import com.example.demo.lectureClass.aggregateRoot.entity.AmountType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AmountRepository extends JpaRepository<Amount, Long> {
    Optional<Amount> findByAmountType(AmountType amountType);
}
