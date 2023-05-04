package kr.eddi.demo.lectureClass.vue.files.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class FileTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer price;
    private String productName;

    @Getter
    private String imagePath;

    public FileTest(Integer price, String productName, String imagePath) {
        this.price = price;
        this.productName = productName;
        this.imagePath = imagePath;
    }
}
