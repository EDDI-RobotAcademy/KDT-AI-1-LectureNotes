package kr.eddi.demo.productTest;

import kr.eddi.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm;
import kr.eddi.demo.lectureClass.testCode.account.entity.TestAccount;
import kr.eddi.demo.lectureClass.testCode.product.controller.form.TestProductRequestForm;
import kr.eddi.demo.lectureClass.testCode.product.entity.TestProduct;
import kr.eddi.demo.lectureClass.testCode.product.service.TestProductService;
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
        final String productName = "또 다른 레고";
        final Integer price = 246000;

        TestProductRequestForm requestForm = new TestProductRequestForm(productName, price);
        TestProduct product = testProductService.register(requestForm);

        assertEquals(productName, product.getProductName());
        assertEquals(price, product.getPrice());
    }
}
