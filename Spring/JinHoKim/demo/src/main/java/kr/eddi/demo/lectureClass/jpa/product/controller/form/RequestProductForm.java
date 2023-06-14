package kr.eddi.demo.lectureClass.jpa.product.controller.form;

import kr.eddi.demo.lectureClass.jpa.product.entity.JpaProduct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class RequestProductForm {
    final private String productName;
    final private Integer price;

    public JpaProduct toJpaProduct() {
        return new JpaProduct(productName, price);
    }
}
