package kr.eddi.demo.productTest;

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
        final Integer price = 236000;

        TestProductRequestForm requestForm = new TestProductRequestForm(productName, price);
//        정보를 UI에서 받아왔다고 생각하고 TestProductRequestForm 객체 생성
        TestProduct product = testProductService.register(requestForm);
//        TestProductService 인터페이스의 register 메소드를 호출 하여 상품을 등록한다.

        assertEquals(productName, product.getProductName());
        assertEquals(price, product.getPrice());
//        상품을 등록한 후 상품의 이름과 가격이 예상한 값과 같은지 확인한다.
//        이렇게 하면 코드가 정확하게 작동하는지 확인할 수 있다.
    }
}