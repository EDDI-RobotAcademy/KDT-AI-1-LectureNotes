package kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeProduct.service;

import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeProduct.controller.form.TestPracticeProductRequestForm;
import kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeProduct.entity.TestPracticeProduct;

public interface TestPracticeProductService {

    TestPracticeProduct register(TestPracticeProductRequestForm requestForm);
}
