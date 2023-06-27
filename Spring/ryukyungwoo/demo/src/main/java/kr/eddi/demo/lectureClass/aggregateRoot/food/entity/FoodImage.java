package kr.eddi.demo.lectureClass.aggregateRoot.food.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor // Lombok을 사용하여 모든 필드를 인자로 받는 생성자를 자동으로 생성합니다.
@NoArgsConstructor // Lombok을 사용하여 기본 생성자 (인자가 없는 생성자)를 자동으로 생성합니다.
@Entity // 이 클래스가 JPA 엔티티임을 명시합니다. 이 클래스는 데이터베이스 테이블과 매핑됩니다.
public class FoodImage {

    @Id // 이 필드가 테이블의 기본 키(Primary Key)에 대응된다는 것을 표시합니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키의 생성 전략을 IDENTITY로 지정합니다. 데이터베이스가 기본 키 값 생성을 담당합니다.
    private Long id;

    // 현재 FoodImage 객체와 Food 객체 간의 1:1 관계 설정입니다.
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    private String uniqueRandomName; // 고유한 무작위 이름을 담은 필드입니다.

    // 고유한 무작위 이름을 인자로 받아 FoodImage 객체를 생성하는 생성자입니다.
    public FoodImage(String uniqueRandomName) {
        this.uniqueRandomName = uniqueRandomName;
    }

    // 고유한 무작위 이름을 인자로 받아 FoodImage 객체를 생성하는 정적 팩토리 메소드입니다.
    public static FoodImage of (String uniqueRandomName) {
        return new FoodImage(uniqueRandomName);
    }

    // Food 객체를 설정하는 setter 메소드입니다. 이를 통해 Food와 FoodImage 간의 양방향 관계를 설정할 수 있습니다.
    public void setFood (Food food) {
        this.food = food;
    }
}
