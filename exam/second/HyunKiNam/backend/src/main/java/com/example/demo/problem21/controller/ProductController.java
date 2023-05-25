package com.example.demo.problem21.controller;

import com.example.demo.problem21.controller.form.ProductRequestForm;
import com.example.demo.problem21.entity.Product;
import com.example.demo.problem21.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    final private ProductService productService;

    @PostMapping("/register")
    public Product registProduct(
            @RequestPart(value = "imageFile") MultipartFile imageFile,
            @RequestPart(value = "productInfo") ProductRequestForm requestForm){

        return productService.register(requestForm.toProductRegisterRequest(imageFile));
    }

    @GetMapping("/list")
    public List<Product> getProductList(){
        List<Product> productList = productService.list();

        return productList;
    }
}
