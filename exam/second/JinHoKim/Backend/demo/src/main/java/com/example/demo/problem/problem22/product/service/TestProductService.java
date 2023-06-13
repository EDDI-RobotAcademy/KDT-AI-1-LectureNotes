package com.example.demo.problem.problem22.product.service;

import com.example.demo.problem.problem22.product.controller.form.TestProductRequestForm;
import com.example.demo.problem.problem22.product.entity.TestProduct;

public interface TestProductService {
    TestProduct register (TestProductRequestForm requestForm);
}