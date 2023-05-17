package kr.eddi.demo.jpa.testJpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity//알아서 테이블을 만들어줌
public class JpaEntityTest {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long entityId;

    private String title;
    private String content;
    private Integer testNumber;
}
