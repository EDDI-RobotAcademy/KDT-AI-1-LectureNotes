package kr.eddi.demo.lectureTest.problem;

import kr.eddi.demo.lectureClass.testCode.problem.product.controller.form.ProductRequestForm;
import kr.eddi.demo.lectureClass.testCode.problem.product.entity.Product;
import kr.eddi.demo.lectureClass.testCode.problem.product.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductTest {
    @Autowired
    ProductService productService;

    @Test
    @DisplayName("사업자 회원이 상품을 등록한다.")
    void 사업자_회원이_상품을_등록한다() {
        final String productName = "lego";
        final Integer price = 19800;

        ProductRequestForm productRequestForm= new ProductRequestForm(productName, price);
        Product product = productService.register(productRequestForm.toProduct());

        assertEquals(productName, product.getProductName());
        assertEquals(price, product.getPrice());

    }

}
