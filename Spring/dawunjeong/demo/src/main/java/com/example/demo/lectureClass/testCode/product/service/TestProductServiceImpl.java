package com.example.demo.lectureClass.testCode.product.service;

import com.example.demo.lectureClass.testCode.product.controller.form.TestProductRequestForm;
import com.example.demo.lectureClass.testCode.product.entity.TestProduct;
import com.example.demo.lectureClass.testCode.product.repository.TestProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestProductServiceImpl implements TestProductService{

    final private TestProductRepository productRepository;

    @Override
    public TestProduct register(TestProductRequestForm requestForm) {
        final Optional<TestProduct> maybeProduct =
                productRepository.findByProductName(requestForm.getProductName());

        if(maybeProduct.isPresent()) {
            log.debug("이미 등록된 상품입니다!");
            return null;
        }

        return productRepository.save(requestForm.toTestProduct());
    }
}
