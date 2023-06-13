package kr.eddi.demo.lectureClass.aggregateRoot.food.entity;

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
    // optional 속성은 연관된 엔티티가 필수적인지를 지정합니다.
    // optional = false 로 설정하면 연관된 엔티티가 반드시 존재해야 한다는 의미입니다.
    // 따라서 해당 연관 관계는 null 이 아닌 값을 가져야 합니다.
    // 만약 optional = true 로 설정하면 연관된 엔티티가 없을 때에도 관계를 유지할 수 있으며,
    // 연관된 엔티티는 null 이 될 수 있습니다.
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

    public Amount getAmount () {
        return amount;
    }
}