package kr.eddi.demo;

import kr.eddi.demo.problem1319.Account.service.AccountService;
import kr.eddi.demo.problem1319.product.controller.form.ProductRequestForm;
import kr.eddi.demo.problem1319.product.entity.Product;
import kr.eddi.demo.problem1319.product.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Problem22Test {

    @Autowired
    private AccountService accountService;
    @Autowired
    private ProductService productService;

    @Test
    @DisplayName("사업자 회원의 상품 등록")
    void 사업자_회원_상품_등록() {
        final String email = "gogo@naver.com";
        final String productName = "상자";
        final String imgSrc="tomato.jpg";
        final Integer price = 4000;

        // 우선 이메일이 사업자 회원의 것인지 체크해야함

        Boolean checkBusiness = accountService.isBusiness(email);
        // 여기까지는 넘어오는거 같은데 그다음이 왜 안되는가...
        if (checkBusiness) {
            ProductRequestForm requestForm = new ProductRequestForm(productName, imgSrc,price);
            Product product= productService.register(requestForm);


            assertEquals(productName, product.getProductName());
            assertEquals(price, product.getPrice());
            assertEquals(imgSrc,product.getImgSrc());
        }

    }
}
