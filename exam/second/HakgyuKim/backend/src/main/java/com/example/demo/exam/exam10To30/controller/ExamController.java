package com.example.demo.exam.exam10To30.controller;

import com.example.demo.exam.exam10To30.account.form.AccountRegisterForm;
import com.example.demo.exam.exam10To30.account.form.LoginRequestForm;
import com.example.demo.exam.exam10To30.account.form.LoginResponseForm;
import com.example.demo.exam.exam10To30.account.service.AccountService;
import com.example.demo.exam.exam10To30.product.entity.Product;
import com.example.demo.exam.exam10To30.product.form.ProductRegisterForm;
import com.example.demo.exam.exam10To30.product.form.ProductResponseForm;
import com.example.demo.exam.exam10To30.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/exam")
@RequiredArgsConstructor
public class ExamController {

    final private AccountService accountService;
    final private ProductService productService;

    // 13번
    @PostMapping("/make-account")
    public Boolean makeAccount (@RequestBody AccountRegisterForm registerForm) {
        return accountService.register(registerForm.toAccountRegisterRequest());
    }

    // 19번
    @PostMapping("/login")
    public LoginResponseForm login (@RequestBody LoginRequestForm requestForm) {
        return accountService.login(requestForm);
    }

    @PostMapping("/check-role")
    public Boolean checkRole (@RequestBody LoginResponseForm responseForm) {
        log.info("responseForm");
        return accountService.checkRole(responseForm);
    }

    @PostMapping(value = "/register-product",
            consumes = { MediaType.MULTIPART_FORM_DATA_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})
    public void productRegister (
            @RequestPart(value = "imageFile") MultipartFile imageFile,
            @RequestPart(value = "productInfo") ProductRegisterForm registerForm) {

        productService.register(imageFile, registerForm.toProductRegisterRequest(imageFile));
}

    @GetMapping("/get-products")
    public List<ProductResponseForm> productList () {
        return productService.list();
    }
}
