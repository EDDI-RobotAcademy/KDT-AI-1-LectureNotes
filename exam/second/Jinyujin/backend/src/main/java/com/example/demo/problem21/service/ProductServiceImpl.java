package com.example.demo.problem21.service;

import com.example.demo.problem21.entity.ProductExam;
import com.example.demo.problem21.repository.ProductImageRepository;
import com.example.demo.problem21.repository.ProductRepository;
import com.example.demo.problem21.service.request.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    final ProductRepository productRepository;
    final ProductImageRepository imageRepository;

    @Override
    public ProductExam register(ProductRequest productRequest) {

        final ProductExam product = productRequest.toProduct();
        return productRepository.save(product);
    }
}
