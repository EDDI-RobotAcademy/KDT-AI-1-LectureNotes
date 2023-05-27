package kr.eddi.demo.refactorProduct.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@ToString
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private Integer price;
    private String productInfo;

    @JsonManagedReference
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductImages> productImagesList = new ArrayList<>();

    public Product(String productName, Integer price, String productInfo) {
        this.productName = productName;
        this.price = price;
        this.productInfo = productInfo;
    }
    public void setProductImages(ProductImages productImages){
        productImagesList.add(productImages);
        productImages.setProduct(this);
    }
}
