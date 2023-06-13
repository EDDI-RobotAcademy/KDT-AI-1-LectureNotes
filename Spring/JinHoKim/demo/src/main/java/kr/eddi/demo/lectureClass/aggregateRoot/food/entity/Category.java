package kr.eddi.demo.lectureClass.aggregateRoot.food.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categoryType")
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;
    //@Enumerated 어노테이션은 열거형 필드의 매핑 방식을 지정하는데 사용되며,
    // EnumType.STRING 매개변수는 해당 열거형 필드를 문자열로 매핑하도록 지정합니다.

    public Category(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public CategoryType getCategoryType () {
        return categoryType;
    }
}