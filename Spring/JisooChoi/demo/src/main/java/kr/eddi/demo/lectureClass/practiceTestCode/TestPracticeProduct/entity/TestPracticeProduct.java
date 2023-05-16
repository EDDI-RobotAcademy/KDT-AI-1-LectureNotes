package kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeProduct.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class TestPracticeProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private Integer productId;

    public TestPracticeProduct(String productName, Integer productId) {
        this.productName = productName;
        this.productId = productId;
    }
}
