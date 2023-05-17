package com.example.demo.problem22;

import com.example.demo.problem.problem22.product.controller.form.TestProductRequestForm;
import com.example.demo.problem.problem22.product.entity.TestProduct;
import com.example.demo.problem.problem22.product.service.TestProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductTest {

    @Autowired
    private TestProductService testProductService;

    @Test
    @DisplayName("사업자 회원이 상품을 등록합니다.")
    void 사업자가_상품을_등록합니다 () {
        final String productName = "신세경";
        final Integer price = 20000;

        TestProductRequestForm requestForm = new TestProductRequestForm(productName, price);
        TestProduct product = testProductService.register(requestForm);

        assertEquals(productName, product.getProductName());
        assertEquals(price, product.getPrice());
    }
}