package com.example.demo.problem.product.service;

import com.example.demo.problem.product.controller.form.ProductReadResponseForm;
import com.example.demo.problem.product.service.request.ProductRegisterRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    Boolean register(ProductRegisterRequest request, List<MultipartFile> imageFileList);

    ProductReadResponseForm read(Long productId);
}
