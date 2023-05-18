package kr.eddi.demo.testCode.product.service;

import kr.eddi.demo.testCode.product.controller.form.TestProductRequestForm;
import kr.eddi.demo.testCode.product.entity.TestProduct;


public interface TestProductService {
    TestProduct register (TestProductRequestForm requestForm);
}