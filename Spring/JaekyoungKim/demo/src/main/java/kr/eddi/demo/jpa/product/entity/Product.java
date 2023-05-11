package kr.eddi.demo.jpa.product.entity;

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

@Getter
@Entity
@ToString
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String title;

    private String content;
    private Integer price;

    public Product(String title, String content, Integer price) {
        this.title = title;
        this.content = content;
        this.price = price;
    }
    @CreationTimestamp
    private LocalDateTime createDate;//만든 시간 찍이도록 함

    @UpdateTimestamp
    private LocalDateTime updateDate;
}
