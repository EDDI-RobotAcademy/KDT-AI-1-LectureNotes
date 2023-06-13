package com.example.demo.lectureClass.aggregateRoot.food.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class FoodAmount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer foodPrice;
    private Integer foodCalorie;
    private Integer unit;
    private Integer max;
    private Integer min;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "amount_id")
    private Amount amount;

    public FoodAmount(Food food, Amount amount,
                      Integer foodPrice, Integer foodCalorie,
                      Integer unit, Integer max, Integer min) {
        this.foodPrice = foodPrice;
        this.foodCalorie = foodCalorie;
        this.unit = unit;
        this.max = max;
        this.min = min;
        this.food = food;
        this.amount = amount;
    }

    public Amount getAmount () {
        return amount;
    }
}
