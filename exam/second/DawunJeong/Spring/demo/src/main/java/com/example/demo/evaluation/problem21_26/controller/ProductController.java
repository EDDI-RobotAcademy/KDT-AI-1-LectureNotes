package com.example.demo.evaluation.problem21_26.controller;

import com.example.demo.evaluation.problem21_26.controller.form.ProductRegisterRequestForm;
import com.example.demo.evaluation.problem21_26.entity.Product;
import com.example.demo.evaluation.problem21_26.service.ProductService;
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
    @PostMapping("/register")
    public Product productRegister(@RequestBody ProductRegisterRequestForm productRegisterRequestForm) {
        log.info("productRegister(): ");
        return productService.register(productRegisterRequestForm);
    }

    @GetMapping("/list")
    public List<Product> productList () {
        log.info("productList()");

        List<Product> returnedProductList = productService.list();
        log.info("returnedProductList: " + returnedProductList);

        return returnedProductList;
    }
    @GetMapping("/{id}")
    public Product readProduct (@PathVariable("id") Long id) {
        log.info("readProduct()");

        return productService.read(id);
    }
}
