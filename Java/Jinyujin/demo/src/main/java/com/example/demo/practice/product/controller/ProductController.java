package com.example.demo.practice.product.controller;

import com.example.demo.practice.product.controller.form.ProductRequestForm;
import com.example.demo.practice.product.entity.ProductEntity;
import com.example.demo.practice.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    final private ProductService productService;

    @GetMapping("/list")
    public List<ProductEntity> productList() {
        return productService.productList();
    }

    @PostMapping("/register")
    public ProductEntity productRegister(@RequestBody ProductRequestForm productRequestForm) {

        log.info("productRegister()");
        return productService.productRegister(productRequestForm.toProductEntity());
    }

    @GetMapping("/{productId}")
    public ProductEntity productRead(@PathVariable Long productId) {
        return productService.productRead(productId);
    }

    @DeleteMapping("/{productId}")
    public void productDelete(@PathVariable Long productId) {
        productService.productDelete(productId);
    }

    @PutMapping("/{productId}")
    public ProductEntity productModify (@PathVariable Long productId, @RequestBody ProductRequestForm productRequestForm) {
        return productService.productModify(productId, productRequestForm);
    }
}
