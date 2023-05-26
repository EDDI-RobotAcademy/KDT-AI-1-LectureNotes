package com.example.demo.problem21.service;

import com.example.demo.problem21.controller.form.ProductRegisterRequest;
import com.example.demo.problem21.controller.form.ProductRequestForm;
import com.example.demo.problem21.entity.Product;
import com.example.demo.problem21.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    final private ProductRepository productRepository;

    @Override
    public Product register(ProductRegisterRequest requestForm) {

        final Product product = requestForm.toProduct();
        productRepository.save(product);

        return product;
    }

    @Override
    public List<Product> list() {
        return productRepository.findAll();
    }
}
