package kr.eddi.demo.lectureClass.aggregateRoot.food.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity // 이 클래스가 JPA 엔티티임을 명시합니다. 이 클래스는 데이터베이스 테이블과 매핑됩니다.
@Table(name = "amountType") // 이 엔티티와 데이터베이스 테이블을 매핑합니다. 여기서는 테이블 이름을 "amountType"으로 지정합니다.
@NoArgsConstructor // Lombok을 사용하여 기본 생성자 (인자가 없는 생성자)를 자동으로 생성합니다.
public class Amount {

    @Id // 이 필드가 테이블의 기본 키(Primary Key)에 대응된다는 것을 표시합니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키의 생성 전략을 IDENTITY로 지정합니다. 데이터베이스가 기본 키 값 생성을 담당합니다.
    private Long id;

    @Enumerated(EnumType.STRING) // 이 속성을 Enum 타입의 데이터베이스 컬럼과 매핑합니다. 여기서는 Enum 값을 문자열로 저장합니다.
    private AmountType amountType; // AmountType이라는 Enum 타입의 필드입니다.

    // AmountType 인자를 받아 객체를 생성하는 생성자입니다.
    public Amount(AmountType amountType) {
        this.amountType = amountType;
    }

    // AmountType값을 반환하는 getter 메소드입니다.
    public AmountType getAmountType () {
        return amountType;
    }
}

