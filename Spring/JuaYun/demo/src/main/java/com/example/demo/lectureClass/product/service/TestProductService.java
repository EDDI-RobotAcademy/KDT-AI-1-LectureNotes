package com.example.demo.lectureClass.product.service;

import com.example.demo.lectureClass.product.controller.form.TestProductRequestForm;
import com.example.demo.lectureClass.product.entity.TestProduct;

public interface TestProductService {
    TestProduct register(TestProductRequestForm requestForm);

}
