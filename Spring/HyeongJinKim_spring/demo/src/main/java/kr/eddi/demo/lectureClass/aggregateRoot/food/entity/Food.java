package kr.eddi.demo.lectureClass.aggregateRoot.food.entity;

import jakarta.persistence.*;
import lombok.Getter;
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
    }
}
