package kr.eddi.demo.lectureClass.product.controller.form;

import kr.eddi.demo.lectureClass.product.entity.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class RequestProductForm {
    final private String productName;
    final private Integer price;

    public Product toProduct(){
        return new Product(productName,price);
    }
}
