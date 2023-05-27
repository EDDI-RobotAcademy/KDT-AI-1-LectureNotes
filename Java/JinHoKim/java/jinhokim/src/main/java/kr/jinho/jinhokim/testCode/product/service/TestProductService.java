package kr.jinho.jinhokim.testCode.product.service;

import kr.jinho.jinhokim.testCode.product.controller.form.TestProductRequestForm;
import kr.jinho.jinhokim.testCode.product.entity.TestProduct;

public interface TestProductService {
    TestProduct register(TestProductRequestForm requestForm);
}
