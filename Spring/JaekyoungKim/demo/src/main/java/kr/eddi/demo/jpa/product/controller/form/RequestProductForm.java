package kr.eddi.demo.jpa.product.controller.form;

import kr.eddi.demo.jpa.product.entity.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class RequestProductForm {
    final private String title;
    final private String content;
    final private Integer price;

    public Product toProduct(){
        return new Product(title,content,price);
    }
}
