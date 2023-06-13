package com.example.demo.problem21;

import com.example.demo.problem21.controller.form.ProductRegisterRequest;
import com.example.demo.problem21.controller.form.ProductRequestForm;
import com.example.demo.problem21.entity.Product;
import com.example.demo.problem21.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductTest {
    /*
    상품 정보를 입력해 상품등록 요청을 합니다. [VAP-3]
    Success Criteria
    1. 상품등록 버튼을 눌러 정보 입력 페이지로 넘어갑니다.
    2. 상품등록에 필요한 정보를 입력합니다.
    4. 등록 버튼을 눌러 상품등록 요청을 전송합니다.
    To-Do
    1. 상품등록 버튼 생성
    2. 정보 입력 Input 생성 (상품명, 가격)
    4. 등록 버튼을 눌렀을 때 Axios를 통해 상품등록 요청 전송

    상품 등록 요청이 들어오면 받은 정보를 저장합니다. [SAP-3]
    Success Criteria
    1. 상품등록 필요한 정보(name, price, accountId)를 수신합니다.
    2. 수시한 정보를 저장합니다.
    3. 상품등록 결과를 전송합니다.
    To-Do
    1. 상품 정보를 저장할 엔티티 생성
    2. 정보 수신할 Controller 생성
    3. 수신한 정보 Repository에 저장
 */

    @Autowired
    private ProductService productService;

    @Test
    @DisplayName("사업자 회원이 상품을 등록합니다.")
    void 사업자가_상품을_등록합니다 () {
        final String productName = "또 다른 레고";
        final Integer price = 246000;
        final Long accountId = 3L;
        final String imageName = "eeee";

        ProductRegisterRequest requestForm = new ProductRegisterRequest(productName, price, accountId, imageName);
        Product product = productService.register(requestForm);

        assertEquals(productName, product.getName());
        assertEquals(price, product.getPrice());
        assertEquals(accountId, product.getAccountId());
    }
}
