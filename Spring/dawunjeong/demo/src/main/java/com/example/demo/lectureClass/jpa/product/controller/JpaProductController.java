package com.example.demo.lectureClass.jpa.product.controller;

import com.example.demo.lectureClass.jpa.product.controller.form.RequestProductForm;
import com.example.demo.lectureClass.jpa.product.entity.JpaProductTest;
import com.example.demo.lectureClass.jpa.product.service.JpaProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/jpa-product")
public class JpaProductController {

    final private JpaProductService productService;

    @GetMapping("/list")
    public List<JpaProductTest> productList () {
        log.info("productList()");

        List<JpaProductTest> returnedProductList = productService.list();
        log.info("returnedProductList: " + returnedProductList);

        return returnedProductList;
    }
    @PostMapping("/register")
    public JpaProductTest registerProduct (@RequestBody RequestProductForm requestProductForm) {
        log.info("registerProduct()");

        return productService.register(requestProductForm.toJpaProduct());
    }

    @GetMapping("/{productId}")
    public JpaProductTest readProduct (@PathVariable("productId") Long productId) {
        log.info("readProduct()");

        return productService.read(productId);
    }
    @DeleteMapping("/{productId}")
    public void deleteProduct (@PathVariable("productId") Long productId) {
        log.info("deleteProduct()");

        productService.delete(productId);
    }
}
