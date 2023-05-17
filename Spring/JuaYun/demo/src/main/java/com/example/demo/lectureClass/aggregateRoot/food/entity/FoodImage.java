package com.example.demo.lectureClass.aggregateRoot.food.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FoodImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    private String uniqueRandomName;

    public FoodImage(String uniqueRandomName) {
        this.uniqueRandomName = uniqueRandomName;
    }

    public static FoodImage of (String uniqueRandomName) {
        return new FoodImage(uniqueRandomName);
    }

    public void setFood (Food food) {
        this.food = food;
    }
}
