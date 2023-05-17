package com.example.demo.lectureClass.testCode.product.service;

import com.example.demo.lectureClass.testCode.product.controller.form.TestProductRequestForm;
import com.example.demo.lectureClass.testCode.product.entity.TestProduct;
import com.example.demo.lectureClass.testCode.product.reposiory.TestProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestProductServiceImpl implements TestProductService{

    final private TestProductRepository productRepository;

    @Override
    public TestProduct register(TestProductRequestForm requestForm) {
        return productRepository.save(requestForm.toTestProduct());
    }

}
