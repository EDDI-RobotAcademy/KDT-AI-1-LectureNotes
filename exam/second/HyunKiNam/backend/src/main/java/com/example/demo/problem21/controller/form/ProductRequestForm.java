package com.example.demo.problem21.controller.form;


import com.example.demo.problem21.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor
public class ProductRequestForm {
    private String name;
    private Integer price;
    private Long accountId;

    public ProductRegisterRequest toProductRegisterRequest(MultipartFile imageFile){

        return new ProductRegisterRequest(name, price, accountId, imageFile.getOriginalFilename());

    }
}