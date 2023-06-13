package com.example.demo.exam.exam10To30.product.form;

import com.example.demo.exam.exam10To30.product.service.request.ProductRegisterRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@RequiredArgsConstructor
public class ProductRegisterForm {

    final private String name;
    final private Integer price;

    public ProductRegisterRequest toProductRegisterRequest (MultipartFile imageFile) {
        String imageName = imageFile.getOriginalFilename();

        return new ProductRegisterRequest(name, price, imageName);
    }
}
