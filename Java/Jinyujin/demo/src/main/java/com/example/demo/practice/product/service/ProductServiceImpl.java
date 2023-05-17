package com.example.demo.practice.product.service;

import com.example.demo.practice.product.Repository.ProductRepository;
import com.example.demo.practice.product.controller.form.ProductRequestForm;
import com.example.demo.practice.product.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    final private ProductRepository productRepository;

    @Override
    public List<ProductEntity> productList() {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "productId"));
    }

    @Override
    public ProductEntity productRegister(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public ProductEntity productRead(Long productId) {

        Optional<ProductEntity> maybeProduct = productRepository.findById(productId);

        if (maybeProduct.isEmpty()) {
            return null;
        }

        return maybeProduct.get();
    }

    @Override
    public void productDelete(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public ProductEntity productModify(Long productId, ProductRequestForm productRequestForm) {
        Optional<ProductEntity> maybeProduct = productRepository.findById(productId);

        if (maybeProduct.isEmpty()) {
            return null;
        }

        maybeProduct.get().setProductName(productRequestForm.getProductName());
        maybeProduct.get().setPrice(productRequestForm.getPrice());

        return productRepository.save(maybeProduct.get());
    }
}
