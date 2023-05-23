package com.example.demo.lectureClass.aggregateRoot.food.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FoodImage {
    // 일대일 맵핑 해둔 상태

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id") // 없어도 될 수도?
    private Food food;

    private String uniqueRandomName;

    public FoodImage(String uniqueRandomName) {
        this.uniqueRandomName = uniqueRandomName;
    }

    // 객체만 주세요 하고 요청하는 상황 있을 수 있다는데
    public static FoodImage of (String uniqueRandomName) {
        return new FoodImage(uniqueRandomName);
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
