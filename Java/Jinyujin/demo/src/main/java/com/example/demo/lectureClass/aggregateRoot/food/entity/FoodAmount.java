package com.example.demo.lectureClass.aggregateRoot.food.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class FoodAmount {
    // 수량만 관리할 것이냐 전반적으로 다 관리할 것이냐

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer foodPrice; // 가격 정보는 최소 단위 당 가격이기에 amount와 묶임
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

    public FoodAmount(
            Food food, Amount amount,
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

    public Amount getAmount() {
        return amount;
    }
}
