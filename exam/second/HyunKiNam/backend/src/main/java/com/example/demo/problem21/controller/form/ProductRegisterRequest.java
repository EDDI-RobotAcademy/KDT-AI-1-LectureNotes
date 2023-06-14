package com.example.demo.problem21.controller.form;

import com.example.demo.problem21.entity.Product;
import com.example.demo.problem21.entity.ProductImage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@RequiredArgsConstructor
public class ProductRegisterRequest {
    final private String name;
    final private Integer price;
    final private Long accountId;
    final private String uniqueRandomName;

    public Product toProduct(){
        return new Product(name, price, accountId, ProductImage.of(uniqueRandomName));
    }
}
