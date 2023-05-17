package kr.eddi.demo.lectureClass.aggregateRoot.food.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foodName;

    @OneToOne(mappedBy = "food", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private FoodImage foodImage;

    @OneToMany(mappedBy = "food", fetch = FetchType.LAZY)
    private Set<FoodCategory> foodCategories = new HashSet<>();

    @OneToMany(mappedBy = "food", fetch = FetchType.LAZY)
    private Set<FoodAmount> foodAmounts = new HashSet<>();

    public Food(String foodName, FoodImage foodImage) {
        this.foodName = foodName;
        this.foodImage = foodImage;

        foodImage.setFood(this);
        /*
            만들어진 Food 객체 (= this)를 매개변수로
            FoodImage 가 가지고 있는 setFood 메서드로 보내준다.

            -> 왜 보내주나 ?
            개인적인 견해로는 참조 관계 때문으로 보인다.
            Food 객체와 FoodImage 는 1:1 관계로 되어있다.
            JPA 에서 1:1의 경우는 양방향만 존재한다.

            그러므로 Food 에서만 값이 생기는 게 아닌,
            FoodImage 에서도 값이 함께 존재해야 한다고 생각한다.

            -> 값이 존재한다 ??
            말이 이상한데, 값이 실제적으로 존재보다는
            1:1 참조 관계로 되어 있으니까
            FoodImage 에 속성으로 맵핑되어 있는
            food 값이 food 의 id를 ??.,.. 아 뭐지 복잡행
        */
    }
}
