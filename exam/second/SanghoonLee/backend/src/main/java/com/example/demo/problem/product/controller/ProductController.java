package com.example.demo.problem.product.controller;

import com.example.demo.problem.account.service.AccountService;
import com.example.demo.problem.product.controller.form.ProductReadResponseForm;
import com.example.demo.problem.product.controller.form.ProductRegisterRequestForm;
import com.example.demo.problem.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.example.demo.problem.account.entity.RoleType.BUSINESS;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    final private ProductService productService;
    final private AccountService accountService;

    @PostMapping(value = "/register",
            consumes = { MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public Boolean productRegister (
            @RequestPart(value = "imageFileList") List<MultipartFile> imageFileList,
            @RequestPart(value = "productInfo") ProductRegisterRequestForm requestForm) {

        log.info("requestForm: " + requestForm);

        if (accountService.lookup(requestForm.getAccountToken()) != BUSINESS) {
            return false;
        }

        return productService.register(requestForm.toProductRegisterRequest(), imageFileList);
    }

    @GetMapping("/read/{productId}")
    public ProductReadResponseForm productRead (@PathVariable("productId") Long productId) {
        return productService.read(productId);
    }
}
