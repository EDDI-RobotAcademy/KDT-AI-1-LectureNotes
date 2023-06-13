package com.example.demo.problem21.controller;

import com.example.demo.problem21.controller.form.ProductRequestForm;
import com.example.demo.problem21.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/problem24")
public class ProductController {

    final private ProductService productService;

    @PostMapping(value = "/product-register",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})
    public void productRegister (
            @RequestPart(value = "imageFile") MultipartFile imageFile,
            @RequestPart(value = "productInfo") ProductRequestForm productRequestForm) {

        log.info("productRegister()");

        productService.register(productRequestForm.toProductRequest(imageFile));
    }
}
