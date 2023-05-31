package com.example.demo.exam.exam10To30.product.service;

import com.example.demo.exam.exam10To30.product.entity.Product;
import com.example.demo.exam.exam10To30.product.form.ProductResponseForm;
import com.example.demo.exam.exam10To30.product.service.request.ProductRegisterRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    void register(MultipartFile imageFile, ProductRegisterRequest productRegisterRequest);

    List<ProductResponseForm> list();
}
