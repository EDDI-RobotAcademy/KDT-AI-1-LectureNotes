package kr.eddi.demo.lectureClass.aggregateRoot.food.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "amountType")
//@Table(name = "amountType")은 amountType 이라는 이름의 테이블과
// 엔티티 클래스를 매핑하도록 지정하는 것을 의미
@NoArgsConstructor
public class Amount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AmountType amountType;
    // @Enumerated 어노테이션은 열거형 필드의 매핑 방식을 지정하는데 사용되며,
    // EnumType.STRING 매개변수는 해당 열거형 필드를 문자열로 매핑하도록 지정합니다.

    public Amount(AmountType amountType) {
        this.amountType = amountType;
    }

    public AmountType getAmountType () {
        return amountType;
    }
}