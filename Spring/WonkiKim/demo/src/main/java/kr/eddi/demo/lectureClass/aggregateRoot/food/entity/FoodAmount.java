package kr.eddi.demo.lectureClass.aggregateRoot.food.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class FoodAmount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer foodPrice;
    private Integer unit;
    private Integer max;
    private Integer min;
    private Integer calories;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name="food_id")
    private Food food;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name="amount_id")
    private Amount amount;

    public FoodAmount(Integer foodPrice, Integer unit, Integer max, Integer min,
                      Integer calories, Food food, Amount amount) {
        this.foodPrice = foodPrice;
        this.unit = unit;
        this.max = max;
        this.min = min;
        this.calories = calories;
        this.food = food;
        this.amount = amount;
    }

    public Amount getAmount() {
        return amount;
    }
}
