package com.example.demo.lectureClass.aggregateRoot.food.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Food {
    // Food가 Aggregate Root

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foodName;

    // 이미지
    @OneToOne(mappedBy = "food", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    // OneToOne은 두 엔티티 간의 일대일 관계를 정의
    // cascade를 달면 대상 entity에 대해 작업을 수행하면 연결된 entity에도 동일한 작업이 수행되는 것
    // Persist는 상위 Entity에서 하위 Entity로 전파
    // food가 저장을 하면 foodImage도 저장,
    // food가 삭제하면 foodImage도 삭제
    private FoodImage foodImage;
    // food 정보를 표현하기 위한 이미지 정보

    @OneToMany(mappedBy = "food", fetch = FetchType.LAZY)
    private Set<FoodCategory> foodCategories = new HashSet<>();
    // food와 category 표현하는 매개체
    // 실제 판매하는 Food와 이 Food의 Category(고기, 채소 등등)를 구별하기 위한 메타 정보

    @OneToMany(mappedBy = "food", fetch = FetchType.LAZY)
    private Set<FoodAmount> foodAmounts = new HashSet<>();
    // food와 amount 표현하는 매개체
    // 실제 판매하는 Food와 이 Food의 Amount(gram, 개수)를 구별하기 위한 메타 정보
    // 그냥 Amount는 실질적인 값 - 어떤 타입인지에 대한 실질적인 정보가 들어가 있음 (gram, count)

    // Amount와 Category는 앞서서 DBInitializer의 @PostConstruct를 통해
    // 사전에 미리 할당해놓고 필요할 때 사용

    public Food(String foodName, FoodImage foodImage) {
        this.foodName = foodName;
        this.foodImage = foodImage;

        foodImage.setFood(this);
    }
}
