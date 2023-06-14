package com.example.demo.lectureClass.aggregateRoot.food.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

// Food가 어마운트 카테고리 이미지를 가지고 있음
@Entity
@NoArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foodName;

    // 보편적으로 푸드 이미지를 가져올때 OneToOne
    // 디폴트로 OneToOne을 사용하는게 좋음
    @OneToOne(mappedBy = "food", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private FoodImage foodImage;

    // @OneToMany 붙어있는것은 숫자 값이 안보임 (실질적으로 값을 가지지 않음)
    // DB 테이블 만들지 않음
    // 음식 관점에서 참조해야할때 OneToMany 사용
    // 구조적으로 양방향 참조를 하게 됨
    // 객체 이름으로 접근이 가능 (원래는 불가능한 기법인데, Jpa를 사용했기 때문에 가능)
    @OneToMany(mappedBy = "food", fetch = FetchType.LAZY)
    private Set<FoodCategory> foodCategories = new HashSet<>();

    @OneToMany(mappedBy = "food", fetch = FetchType.LAZY)
    private Set<FoodAmount> foodAmounts= new HashSet<>();

    public Food(String foodName, FoodImage foodImage) {
        this.foodName = foodName;
        this.foodImage = foodImage;

        foodImage.setFood(this);
    }
}
