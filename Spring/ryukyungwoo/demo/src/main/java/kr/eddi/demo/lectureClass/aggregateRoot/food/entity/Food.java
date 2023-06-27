package kr.eddi.demo.lectureClass.aggregateRoot.food.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity // 이 클래스가 JPA 엔티티임을 명시합니다. 이 클래스는 데이터베이스 테이블과 매핑됩니다.
@NoArgsConstructor // Lombok을 사용하여 기본 생성�� (인자가 없는 생성자)를 자동으로 생성합니다.
public class Food {

    @Id // 이 필드가 테이블의 기본 키(Primary Key)에 대응된다는 것을 표시합니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키의 생성 전략을 IDENTITY로 지정합니다. 데이터베이스가 기본 키 값 생성을 담당합니다.
    private Long id;

    private String foodName; // 음식 이름을 나타내는 필드입니다.

    // 현재 Food 객체와 FoodImage 객체 간의 1:1 관계를 표현합니다.
    @OneToOne(mappedBy = "food", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private FoodImage foodImage;

    // Food-Categories 간의 관계를 나타내는 필드입니다.
    // 한 개의 Food 객체는 여러 개의 FoodCategory 객체와 관계를 가질 수 있습니다.
    @OneToMany(mappedBy = "food", fetch = FetchType.LAZY)
    private Set<FoodCategory> foodCategories = new HashSet<>();

    // Food-Amounts 간의 관계를 나타내는 필드입니다.
    // 한 개의 Food 객체는 여러 개의 FoodAmount 객체와 관계를 가질 수 있습니다.
    @OneToMany(mappedBy = "food", fetch = FetchType.LAZY)
    private Set<FoodAmount> foodAmounts = new HashSet<>();

    // 음식 이름과 FoodImage 객체를 인자로 받아 Food 객체를 생성하는 생성자입니다.
    public Food(String foodName, FoodImage foodImage) {
        this.foodName = foodName;
        this.foodImage = foodImage;

        // 양방향 관계 설정으로 인해 Food 객체 생성 시 FoodImage 객체의 참조자도 추가합니다.
        foodImage.setFood(this);
    }
}

