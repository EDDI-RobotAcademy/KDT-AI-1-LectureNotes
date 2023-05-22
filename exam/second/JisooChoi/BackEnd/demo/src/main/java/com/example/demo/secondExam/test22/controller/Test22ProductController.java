package com.example.demo.secondExam.test22.controller;

import com.example.demo.secondExam.test22.controller.form.Test22ProductRequestForm;
import com.example.demo.secondExam.test22.entity.Test22Product;
import com.example.demo.secondExam.test22.service.Test22ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/exam-test22")
public class Test22ProductController {

    final private Test22ProductService productService;

    @PostMapping("/register")
    public Test22Product productRegister(@RequestBody Test22ProductRequestForm productRequestForm){
        log.info("productRegister()");
        Test22Product product = productService.register(productRequestForm);
        return product;
    }
}

