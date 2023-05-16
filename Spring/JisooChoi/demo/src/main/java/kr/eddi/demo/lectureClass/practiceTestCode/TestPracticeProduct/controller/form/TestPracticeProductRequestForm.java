package kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeProduct.controller.form;

import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeAccount.entity.TestPracticeAccount;
import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeProduct.entity.TestPracticeProduct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestPracticeProductRequestForm {

    final private String productName;

    public TestPracticeProduct toTestProduct() {
        return new TestPracticeProduct(productName);
    }
}
