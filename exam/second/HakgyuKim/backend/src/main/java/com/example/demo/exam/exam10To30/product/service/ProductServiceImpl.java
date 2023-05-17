package com.example.demo.exam.exam10To30.product.service;

import com.example.demo.exam.exam10To30.product.entity.Product;
import com.example.demo.exam.exam10To30.product.repository.ProductImageRepository;
import com.example.demo.exam.exam10To30.product.repository.ProductRepository;
import com.example.demo.exam.exam10To30.product.service.request.ProductRegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    @Autowired
    final ProductRepository productRepository;
    @Autowired
    final ProductImageRepository productImageRepository;

    @Override
    public void register(MultipartFile imageFile, ProductRegisterRequest productRegisterRequest) {
        final Product product = productRegisterRequest.toProduct();
        productRepository.save(product);

        try {
            FileOutputStream writer = new FileOutputStream("../frontend/src/assets/productImgs/"
                    + imageFile.getOriginalFilename());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> list() {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }
}
