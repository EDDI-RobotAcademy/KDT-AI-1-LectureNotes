package kr.eddi.demo.testCode.product.service;

import kr.eddi.demo.testCode.product.controller.form.TestProductRequestForm;
import kr.eddi.demo.testCode.product.entity.TestProduct;
import kr.eddi.demo.testCode.product.repository.TestProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestProductServiceImpl implements TestProductService {
    final private TestProductRepository productRepository;

    @Override
    public TestProduct register(TestProductRequestForm requestForm) {
        return productRepository.save(requestForm.toTestProduct());
    }
}