package kr.eddi.demo.lectureClass.jpa.testJpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
// entity 가 붙으면 알아서 테이블이 생성되는것을 볼 수 있음
@Entity
public class JpaEntityTest {
    // db자체를 도메인으로 볼 수 있게 해주는것이 Jpa
    // db를 볼 필요가 없음
    // 코드 자체를 직관적으로 볼 수 있어서 Jpa를 사용
    // 생산성을 높히기 위해 사용
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entityId;

    private String title;
    private String content;
    private Integer testNumber;
}