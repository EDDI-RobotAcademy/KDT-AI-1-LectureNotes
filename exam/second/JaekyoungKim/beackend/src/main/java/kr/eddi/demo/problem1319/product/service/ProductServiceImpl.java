package kr.eddi.demo.problem1319.product.service;

import kr.eddi.demo.problem1319.product.controller.form.ProductRequestForm;
import kr.eddi.demo.problem1319.product.entity.Product;
import kr.eddi.demo.problem1319.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    final private ProductRepository productRepository;
    @Override
    public Product register(ProductRequestForm requestForm) {
        return productRepository.save(requestForm.toProduct());
    }
}
