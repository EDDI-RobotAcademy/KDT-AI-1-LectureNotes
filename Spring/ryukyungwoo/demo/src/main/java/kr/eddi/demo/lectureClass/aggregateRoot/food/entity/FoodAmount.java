package kr.eddi.demo.lectureClass.aggregateRoot.food.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // Lombok을 사용하여 모든 필드에 대한 getter 메소드를 자동으로 생성합니다.
@Entity // 이 클래스가 JPA 엔티티임을 명시합니다. 이 클래스는 데이터베이스 테이블과 매핑됩니다.
@NoArgsConstructor // Lombok을 사용하여 기본 생성자 (인자가 없는 생성자)를 자동으로 생성합니다.
public class FoodAmount {

    @Id // 이 필드가 테이블의 기본 키(Primary Key)에 대응된다는 것을 표시합니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키의 생성 전략을 IDENTITY로 지정합니다. 데이터베이스가 기본 키 값 생성을 담당합니다.
    private Long id;

    private Integer foodPrice; // 음식 가격을 나타내는 필드입니다.
    private Integer foodCalorie; // 음식 칼로리를 나타내는 필드입니다.
    private Integer unit; // 양의 단위를 나타내는 필드입니다.
    private Integer max; // 최대 양을 나타내는 필드입니다.
    private Integer min; // 최소 양을 나타내는 필드입니다.

    // 현재 FoodAmount 객체와 Food 객체 간의 다대일(N:1) 관계 설정입니다.
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "food_id")
    private Food food;

    // 현재 FoodAmount 객체와 Amount 객체 간의 다대일(N:1) 관계 설정입니다.
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "amount_id")
    private Amount amount;

    // Food, Amount 객체, 가격, 칼로리, 단위, 최대, 최소 양을 인자로 받아 FoodAmount 객체를 생성하는 생성자입니다.
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

    // Amount 값을 반환하는 getter 메소드입니다.
    public Amount getAmount () {
        return amount;
    }
}

