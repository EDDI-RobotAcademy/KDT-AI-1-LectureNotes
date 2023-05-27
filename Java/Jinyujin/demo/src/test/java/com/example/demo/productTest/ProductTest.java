package com.example.demo.productTest;

import com.example.demo.lectureClass.testCode.product.service.TestProductService;
import com.example.demo.lectureClass.testCode.product.controller.form.TestProductRequestForm;
import com.example.demo.lectureClass.testCode.product.entity.TestProduct;
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
    @DisplayName("사업자 회원이 상품을 등록합니다")
    void 사업자가_상품을_등록합니다() {
        final String productName = "레고";
        final Integer price = 198000;
        // create로 먼저 등록하기
        // 그리고 update로 아래꺼 등록함
        // create로 상품 등록했기 때문에 accountId 다 날라가 있을 것
        // 그럼 account도 하나 update인 상태로 등록해줘야 함

//        final String productName = "또 다른 레고";
//        final Integer price = 200000;

        TestProductRequestForm requestForm = new TestProductRequestForm(productName, price);
        TestProduct product = testProductService.register(requestForm);

        assertEquals(productName, product.getProductName());
        assertEquals(price, product.getPrice());
    }


}
