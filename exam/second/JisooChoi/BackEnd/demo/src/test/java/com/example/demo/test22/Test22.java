package com.example.demo.test22;

import com.example.demo.secondExam.test10.controller.form.Test10AccountRequestForm;
import com.example.demo.secondExam.test10.controller.form.Test17AccountLoginResponseForm;
import com.example.demo.secondExam.test10.service.Test10AccountService;
import com.example.demo.secondExam.test22.controller.form.Test22ProductRequestForm;
import com.example.demo.secondExam.test22.controller.form.Test22ProductResponse;
import com.example.demo.secondExam.test22.entity.Test22Product;
import com.example.demo.secondExam.test22.service.Test22ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Test22 {

    @Autowired
    private Test10AccountService accountService;

    @Autowired
    private Test22ProductService productService;

    @Test
    @DisplayName("사업자 회원이라 검증되면 상품을 등록할 수 있습니다.")
    void 사업자_회원이_상품을_등록합니다 () {
        // 먼저 로그인
        final String email = "businessMan@test.com";
        final Integer password = 1234;
        final String role = "사업자";
        final Integer roleAddNum = 1234567890;

        final String productName = "멜론 티셔츠";
        final Integer productCost = 5000;
        final String productImg = "일단 사진이 들어갈 자리임";

        Test10AccountRequestForm requestForm = new Test10AccountRequestForm(email, password, role, roleAddNum);
        Test17AccountLoginResponseForm memberResponseForm = accountService.login(requestForm);

        // 상품 받아오기
        Test22ProductRequestForm productRequestForm =
                new Test22ProductRequestForm(productName, productCost, productImg, role);
        // 사용자 검증 및 상품 등록
        Test22Product product = productService.register(productRequestForm);

        assertEquals(productName, product.getProductName());
        assertEquals(productCost, product.getProductCost());
    }
}
