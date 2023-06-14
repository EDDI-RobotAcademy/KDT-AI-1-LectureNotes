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
    //CascadeType.PERSIST 는 부모 엔티티를 저장할 때 연관된 자식 엔티티도 함께 저장하도록 지정하는 옵션입니다.
    // 즉, 부모 엔티티가 영속화될 때 자식 엔티티도 자동으로 영속화됩니다.
    // 이 옵션을 사용하면 부모 엔티티와 자식 엔티티 간에 일대다 또는 일대일 관계가 있는 경우,
    // 자식 엔티티를 개별적으로 저장하지 않아도 부모 엔티티를 저장할 때 자식 엔티티도 자동으로 저장됩니다.

    @OneToMany(mappedBy = "food", fetch = FetchType.LAZY)
    private Set<FoodCategory> foodCategories = new HashSet<>();

    @OneToMany(mappedBy = "food", fetch = FetchType.LAZY)
    private Set<FoodAmount> foodAmounts = new HashSet<>();
    //연관 관계는 데이터베이스 테이블에 별도의 열로 표시되지 않고,
    // 해당 엔티티와의 관계를 기반으로 데이터베이스에서 필요한 쿼리를 수행할 수 있도록 돕습니다.

    public Food(String foodName, FoodImage foodImage) {
        this.foodName = foodName;
        this.foodImage = foodImage;

        foodImage.setFood(this);
    }
}