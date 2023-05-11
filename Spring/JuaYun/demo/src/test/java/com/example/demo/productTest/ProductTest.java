package com.example.demo.productTest;

import com.example.demo.lectureClass.manager.entity.TestManager;
import com.example.demo.lectureClass.manager.repository.TestManagerAccountRepository;
import com.example.demo.lectureClass.product.controller.form.TestProductRequestForm;
import com.example.demo.lectureClass.product.entity.TestProduct;
import com.example.demo.lectureClass.product.service.TestProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductTest {

    @Autowired
    private TestProductService testProductService;

    @Autowired
    private TestManagerAccountRepository testManagerAccountRepository;

    @Test
    @DisplayName("사업자 회원이 상품을 등록합니다.")
    void 사업자가_상품을_등록합니다 () {
        final String productName = "레고2";
        final Integer price = 240000;
        

        TestProductRequestForm requestForm = new TestProductRequestForm(productName, price);
        TestProduct product = testProductService.register(requestForm);

        assertEquals(productName, product.getProductName());
        assertEquals(price, product.getPrice());

    }
}
