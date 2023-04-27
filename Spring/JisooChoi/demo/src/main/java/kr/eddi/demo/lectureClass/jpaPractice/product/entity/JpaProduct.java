package kr.eddi.demo.lectureClass.jpaPractice.product.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class JpaProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId; // 상품 고유 번호

    private String productName; // 상품명
    private Integer productPrice; // 상품 가격
    private String manufacturer; // 제조사

    public JpaProduct(String productName, Integer productPrice, String manufacturer) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.manufacturer = manufacturer;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @CreationTimestamp
    private LocalDateTime manufacturingDate; // 제조일자

    // ★유통기한의 타임 스탬프 어노테이션을 뭐로 해야할지 모르겠다.
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @UpdateTimestamp
    private LocalDateTime expirationDate; // 유통기한
    private String category; // 카테고리
}
