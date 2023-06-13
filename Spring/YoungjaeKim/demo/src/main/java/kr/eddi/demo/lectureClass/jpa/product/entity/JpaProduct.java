package kr.eddi.demo.lectureClass.jpa.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class JpaProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId; // 상품 아이디

    private String productName;     // 상품명
    private String productPrice;    // 상품 가격
    private String maker;           // 제조사
    private String EXP;             // 유통기한
    private String MFG;             // 제조일
    private String category;        // 상품 카테고리

    public JpaProduct(String productName, String productPrice, String maker, String EXP, String MFG, String category) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.maker = maker;
        this.EXP = EXP;
        this.MFG = MFG;
        this.category = category;
    }

    @CreatedDate
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime updateDate;
}
