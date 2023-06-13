package kr.eddi.demo.lectureClass.testCode.product.service;

import kr.eddi.demo.lectureClass.testCode.product.controller.form.TestProductRequestForm;
import kr.eddi.demo.lectureClass.testCode.product.entity.TestProduct;

public interface TestProductService {
    TestProduct register (TestProductRequestForm requestForm);
}
