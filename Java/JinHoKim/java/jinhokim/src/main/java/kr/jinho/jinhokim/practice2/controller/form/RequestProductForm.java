package kr.jinho.jinhokim.practice2.controller.form;

import kr.jinho.jinhokim.practice2.entity.JpaProduct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class RequestProductForm {
    final private String productName;
    final private Integer price;

    public JpaProduct toJpaProduct() {
        return new JpaProduct(productName, price);
    }
}
