package com.example.demo.lectureClass.aggregateRoot.food.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "amountType")
@NoArgsConstructor
public class Amount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AmountType amountType;

    public Amount(AmountType amountType) {
        this.amountType = amountType;
    }

    public AmountType getAmountType(){
        return amountType;
    }
}
