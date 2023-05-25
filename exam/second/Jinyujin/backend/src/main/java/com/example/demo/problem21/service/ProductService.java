package com.example.demo.problem21.service;

import com.example.demo.problem21.entity.ProductExam;
import com.example.demo.problem21.service.request.ProductRequest;

public interface ProductService {
    ProductExam register(ProductRequest productRequest);
}
