package kr.eddi.demo.refactorProduct.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString(exclude = { "product" })
@Entity
@NoArgsConstructor
public class ProductImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String imageResourcePath;

    @Setter
    @JsonBackReference//데이터 매핑중 직렬화 하여 순환 참조르 해결 하기 위해 사용함
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductImages(String imageResourcePath) {
        this.imageResourcePath = imageResourcePath;
    }
}
