package kr.eddi.demo.lectureClass.testCode.problem.product.controller.form;

import kr.eddi.demo.lectureClass.testCode.problem.product.entity.Product;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductRequestForm {
    final private String productName;
    final private Integer price;

    public Product toProduct() {
        return new Product(productName, price);
    }
}
