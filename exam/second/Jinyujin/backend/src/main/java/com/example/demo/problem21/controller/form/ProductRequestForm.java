package com.example.demo.problem21.controller.form;

import com.example.demo.problem21.service.request.ProductRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class ProductRequestForm {

    final private String productName;
    final private Integer price;

    public ProductRequest toProductRequest(MultipartFile imageFile) {

        UUID randomPrefix = UUID.randomUUID();
        String uniqueRandomName= randomPrefix + imageFile.getOriginalFilename();

        return new ProductRequest(productName, price, uniqueRandomName);
    }
}
