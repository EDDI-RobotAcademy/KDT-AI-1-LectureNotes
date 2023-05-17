package kr.eddi.demo.lectureClass.testCode.product.service;

import kr.eddi.demo.lectureClass.testCode.product.entity.TestProduct;
import kr.eddi.demo.lectureClass.testCode.product.controller.form.TestProductRequestForm;

public interface TestProductService {
    TestProduct register(TestProductRequestForm requestForm);
}
