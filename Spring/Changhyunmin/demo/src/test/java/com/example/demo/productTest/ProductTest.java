package com.example.demo.productTest;

import kr.eddi.demo.DemoApplication;
import kr.eddi.demo.lectureClass.testCode.product.controller.form.TestProductRequestForm;
import kr.eddi.demo.lectureClass.testCode.product.entity.TestProduct;
import kr.eddi.demo.lectureClass.testCode.product.service.TestProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
public class ProductTest {
    @Autowired
    private TestProductService testProductService;

    @Test
    @DisplayName("사업자 회원이 상품을 등록합니다.")
    void 사업자가_상품을_등록합니다 () {
        final String productName = "래고";
        final Integer price = 198000;

        TestProductRequestForm requestForm = new TestProductRequestForm(productName, price);
        TestProduct product = testProductService.register(requestForm);

        assertEquals(productName, product.getProductName());
        assertEquals(price, product.getPrice());

    }
}
