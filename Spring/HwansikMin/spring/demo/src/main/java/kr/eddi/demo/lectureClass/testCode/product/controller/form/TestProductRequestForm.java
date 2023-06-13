package kr.eddi.demo.lectureClass.testCode.product.controller.form;

import kr.eddi.demo.lectureClass.testCode.product.entity.TestProduct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestProductRequestForm {

    final private String productName;
    final private Integer price;

    public TestProduct toTestProduct() {
        return new TestProduct(productName, price);
    }
}
