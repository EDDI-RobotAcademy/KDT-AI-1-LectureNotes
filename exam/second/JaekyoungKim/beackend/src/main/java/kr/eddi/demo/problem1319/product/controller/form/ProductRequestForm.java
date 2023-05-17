package kr.eddi.demo.problem1319.product.controller.form;

import kr.eddi.demo.problem1319.product.entity.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class ProductRequestForm {
    final private String productName;
    final private String imgSrc;
    final private Integer price;


    public Product toProduct() {
        return new Product(productName,imgSrc, price);
    }

}