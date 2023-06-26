package com.example.demo.lectureClass.jpa.product.service;


import com.example.demo.lectureClass.jpa.product.controller.form.RequestProductForm;
import com.example.demo.lectureClass.jpa.product.entity.reactProduct;
import com.example.demo.lectureClass.jpa.product.repository.JpaProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class JpaProductServiceImpl implements JpaProductService {

    final private JpaProductRepository productRepository;

    @Override
    public List<reactProduct> list() {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "productId"));
    }

    @Override
    public reactProduct register(reactProduct reactProduct) {
        return productRepository.save(reactProduct);
    }

    @Override
    public reactProduct read(Long productId) {
        Optional<reactProduct> maybeJpaProduct = productRepository.findById(productId);

        if (maybeJpaProduct.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }

        return maybeJpaProduct.get();
    }

    @Override
    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public reactProduct modify(Long productId, RequestProductForm requestProductForm) {
        Optional<reactProduct> maybeJpaProduct = productRepository.findById(productId);

        if (maybeJpaProduct.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }

        reactProduct product = maybeJpaProduct.get();
        product.setProductName(requestProductForm.getProductName());
        product.setPrice(requestProductForm.getPrice());

        return productRepository.save(product);
    }
}
